
/**
 * 
 */
package com.jimmyc.tiendamusicalweb.controllers;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.jimmyc.tiendamusicalentities.entities.CarritoAlbum;
import com.jimmyc.tiendamusicalservices.service.CarritoService;
import com.jimmyc.tiendamusicalweb.session.SessionBean;

/**
 * @author JimmyC
 * Clase que se encarga de controlar el flujo de la pantalla del carrito de compras.
 */

@ManagedBean
@ViewScoped
public class CarritoController {
	/**
	 * Objeto que permite mostrar los mensajes de LOG en la consola del servidor o en un archivo externo
	 */

	private static final Logger LOGGER = LogManager.getLogger(CarritoController.class);
	
	/**
	 * Objeto que contiene la informacion en sesion del usuario
	 */
	@ManagedProperty("#{sessionBean}")
	private SessionBean sessionBean;
	
	/**
	 * Objeto que realiza la logica de negocio para el carrito de compras
	 */
	@ManagedProperty("#{carritoServiceImpl}")
	private CarritoService carritoServiceImpl;
	/**
	 * Inicializa la informacion de la pantalla del carrito
	 */
	@PostConstruct
	public void init() {
		this.sessionBean.setPaso(0);
		this.calcularTotal();
	}
	
	/**
	 * Metodo que permite calcular el total de la compra con respecto a los albums en el carrito.
	 */
	public void calcularTotal() {
		LOGGER.info("Calculando el total...");

		float total = this.carritoServiceImpl.calcularTotal(this.sessionBean.getPersona().getCarrito());
		this.sessionBean.setTotalCompra(total);
	}

	/**
	 * Metodo que permite eliminar un album del carrito del usuario
	 * @param carritoAlbum {@link CarritoAlbum} objeto con el album a eliminar del carrito
	 */
	public void eliminarAlbumCarrito(CarritoAlbum carritoAlbum) {
		LOGGER.info("Eliminando album "+ carritoAlbum.getAlbum().getNombre() + " del carrito...");
		
		this.carritoServiceImpl.eliminarAlbumCarrito(carritoAlbum);
		this.sessionBean.getPersona().getCarrito().getCarritosAlbum().remove(carritoAlbum);
		this.calcularTotal();
	}
	
	/**
	 * Metodo que permite actualizar la cantidad y los totales del album a comprar.
	 * @param carritoAlbum {@link CarritoAlbum} objeto que contiene el album a actualizar y su cantidad.
	 */
	public void actualizarCantidadCarrito(CarritoAlbum carritoAlbum) {
		float totalCompra = this.carritoServiceImpl.actualizarAlbumCantidad(carritoAlbum, this.sessionBean.getPersona().getCarrito());
		
		this.sessionBean.setTotalCompra(totalCompra);
	}
	/**
	 * @return the sessionBean
	 */
	public SessionBean getSessionBean() {
		return sessionBean;
	}

	/**
	 * @param sessionBean the sessionBean to set
	 */
	public void setSessionBean(SessionBean sessionBean) {
		this.sessionBean = sessionBean;
	}

	/**
	 * @return the carritoServiceImpl
	 */
	public CarritoService getCarritoServiceImpl() {
		return carritoServiceImpl;
	}

	/**
	 * @param carritoServiceImpl the carritoServiceImpl to set
	 */
	public void setCarritoServiceImpl(CarritoService carritoServiceImpl) {
		this.carritoServiceImpl = carritoServiceImpl;
	}
}
