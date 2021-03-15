/**
 * 
 */
package com.jimmyc.tiendamusicalweb.paypal;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.google.gson.Gson;
import com.jimmyc.tiendamusicalentities.entities.CarritoAlbum;
import com.jimmyc.tiendamusicalweb.session.SessionBean;
import com.paypal.http.HttpResponse;
import com.paypal.orders.AddressPortable;
import com.paypal.orders.AmountBreakdown;
import com.paypal.orders.AmountWithBreakdown;
import com.paypal.orders.ApplicationContext;
import com.paypal.orders.Item;
import com.paypal.orders.Money;
import com.paypal.orders.Name;
import com.paypal.orders.Order;
import com.paypal.orders.OrderRequest;
import com.paypal.orders.OrdersCreateRequest;
import com.paypal.orders.Payer;
import com.paypal.orders.PurchaseUnitRequest;
import com.paypal.orders.ShippingDetail;

/**
 * @author JimmyC
 * Clase que se encarga de generar la estructura y la orden de la informacion de la compra que desea realizar el usuario en paypal.
 */
public class PayPalCreateOrder extends PayPalClient {
	/**
	 * Objeto que permite mostrar los mensajes de LOG en la consola del servidor o en un archivo externo
	 */
	private static final Logger LOGGER = LogManager.getLogger(PayPalCreateOrder.class);
	
	/**
	 * Objeto que contiene la orden de pago de la compra
	 */
	private OrderRequest orderRequest;
	
	/**
	 * Metodo que se encarga de generar la orden de compra de los productos para el boton de Paypal.
	 * @param sessionBean {@link SessionBean} objeto con la informacion del carrito del usuario en sesion
	 * @return {@link HttpResponse} objeto que obtiene una respuesta http del servicio de paypal.
	 * @throws IOException {@link IOException} excepcion en caso de error al generar la transaccion de compra con Paypal.
	 */
	public HttpResponse<Order> crearOrden(SessionBean sessionBean) throws IOException {
		LOGGER.info("Ingresando a la funcion de crearOrden...");
		
		OrdersCreateRequest ordersCreateRequest = new OrdersCreateRequest();
		ordersCreateRequest.prefer("return=representation");
		ordersCreateRequest.requestBody(this.generarCuerpoOrden(sessionBean));
		
		HttpResponse<Order> response = client().execute(ordersCreateRequest);
		
		sessionBean.setOrder(response);
		
		return response;
	}
	
	/**
	 * Metodo que permite generar el cuerpo de la informacion del formulario de pago de PayPal con el detalle de toda la transaccion, 
	 * @param sessionBean {@link SessionBean} objeto con la informacion de session de los productos del carrito
	 * @return {@link OrderRequest} objeto con la solicitud de la orden de compra
	 */
	private OrderRequest generarCuerpoOrden(SessionBean sessionBean) {
		//se genera el objeto de solicitud de la orden a mostrar con la informacion del carrito en Paypal.
		this.orderRequest = new OrderRequest();
		
		//Cliente que realiza la aprobacion de la compra
		Payer payer = new Payer();
		
		this.orderRequest.checkoutPaymentIntent("CAPTURE");
		
		//se configura la landingpage, el nombre de la empresa que vende el producto y la direccion de envio.
		ApplicationContext applicationContext = new ApplicationContext().brandName("JimmyC S.A.")
				.landingPage("BILLING").shippingPreference("SET_PROVIDED_ADDRESS");
		
		this.orderRequest.applicationContext(applicationContext);
		
		//Se obtienen los datos personales del comprador
		String nombre = sessionBean.getPersona().getNombre();
		String primerApellido = sessionBean.getPersona().getPrimerApellido();
		String segundoApellido = sessionBean.getPersona().getSegundoApellido();
		
		//se crea la lista de unidades de compra a mostrarse en el formulario de paypal
		List<PurchaseUnitRequest> purchaseUnitRequests = new ArrayList<PurchaseUnitRequest>();
	
		List<Item> items = new ArrayList<Item>();
		
		//se obtiene los productos seleccionados en el carrito de la persona o usuario en sesion.
		List<CarritoAlbum> carritoAlbums = sessionBean.getPersona().getCarrito().getCarritosAlbum();
		
		//Se definen las variables que indicaran los impuestos de la compra.
		double impuestoPorProducto = 10.00;
		double impuestoSumaTotalProductos = 0.0;
		
		//se obtienen e iteran cada producto del carrito y se agregan al objeto item de paypal para mostrarse en el detalle de compra de paypal
		for (CarritoAlbum carritoAlbum : carritoAlbums) {
			Item item = new Item();
			
			item.name(carritoAlbum.getAlbum().getNombre());
			
			String descripcionCorta = carritoAlbum.getAlbum().getDescripcion().substring(0, 50);
			
			item.description(descripcionCorta);
			item.unitAmount(new Money().currencyCode("MXN").value(String.valueOf(carritoAlbum.getAlbum().getValor())));
			item.tax(new Money().currencyCode("MXN").value(String.valueOf(impuestoPorProducto)));
			item.quantity(String.valueOf(carritoAlbum.getCantidad()));
			item.category("PHYSICAL_GOODS");
			item.sku("sku1");
			
			items.add(item);
			
			impuestoSumaTotalProductos += (impuestoPorProducto * carritoAlbum.getCantidad());
			
		}
		
		//Se configura el detalle el detalle de envio de los productos.
		ShippingDetail shippingDetail = new ShippingDetail();
		shippingDetail.name(new Name().fullName(nombre + " " + primerApellido + " " + segundoApellido));
		shippingDetail.addressPortable(new AddressPortable().addressLine1("CALLE SANCHO DAVILA 221")
															.addressLine2("URB. EL BOSQUE, RIMAC")
															.adminArea1("PERÚ")
															.adminArea2("LIMA")
															.postalCode("51")
															.countryCode("PE"));
		
		//Se aplica un formato a la cantidad del total de compra de los productos
		DecimalFormat decimalFormat = new DecimalFormat("#.##");
		double totalConDecimales = Double.valueOf(decimalFormat.format(sessionBean.getTotalCompra()));
		double envio = 20.00;
		double handling = 10.00;
		double descuentoEnvio = 20.00;
		
		double totalCompraConImpuesto = totalConDecimales + impuestoSumaTotalProductos + handling + (envio - descuentoEnvio);
		
		//Se agrega la informacion calculada con los items en la unidad de compra
		PurchaseUnitRequest purchaseUnitRequest = new PurchaseUnitRequest();
		purchaseUnitRequest.items(items);
		
		purchaseUnitRequest.shippingDetail(shippingDetail);
		purchaseUnitRequest.amountWithBreakdown(new AmountWithBreakdown()
				.currencyCode("MXN").value(String.valueOf(totalCompraConImpuesto))
				.amountBreakdown(new AmountBreakdown()
						.itemTotal(new Money().currencyCode("MXN").value(String.valueOf(totalConDecimales)))
						.shipping(new Money().currencyCode("MXN").value(String.valueOf(envio)))
						.handling(new Money().currencyCode("MXN").value(String.valueOf(handling)))
						.taxTotal(new Money().currencyCode("MXN").value(String.valueOf(impuestoSumaTotalProductos)))
						.shippingDiscount(new Money().currencyCode("MXN").value(String.valueOf(descuentoEnvio)))));
		
		//Se agrega la unidad de compra a la lista y a la orden final de compra.
		purchaseUnitRequests.add(purchaseUnitRequest);
		this.orderRequest.purchaseUnits(purchaseUnitRequests);
		
		payer.addressPortable(purchaseUnitRequest.shippingDetail().addressPortable());
		
		this.orderRequest.payer(payer);
		
		Gson gson = new Gson();
		LOGGER.info(gson.toJson(purchaseUnitRequests));
		
		return this.orderRequest;
		
	}
}
