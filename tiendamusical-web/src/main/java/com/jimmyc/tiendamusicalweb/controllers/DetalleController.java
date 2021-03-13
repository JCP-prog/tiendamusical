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

import com.jimmyc.tiendamusicalentities.dto.ArtistaAlbumDTO;
import com.jimmyc.tiendamusicalentities.entities.CarritoAlbum;
import com.jimmyc.tiendamusicalservices.service.CarritoService;
import com.jimmyc.tiendamusicalweb.session.SessionBean;

/**
 * @author JimmyC
 * Clase que controla el flujo de la pantalla de detalle.xhtml
 */

@ManagedBean
@ViewScoped
public class DetalleController {

	/**
	 * Objeto que permite mostrar los mensajes de LOG en la consola del servidor o en un archivo externo
	 */
	private static final Logger LOGGER = LogManager.getLogger(DetalleController.class);
	
	/**
	 * Cantidad del producto seleccionado
	 */
	private int cantidadAlbumSeleccionada;
	
	/**
	 * Objeto que contiene los metodos de la logica de negocio del carrito
	 */
	@ManagedProperty("#{carritoServiceImpl}")
	private CarritoService carritoServiceImpl;
	
	/**
	 * Objeto que contiene la informacion del usuario en sesion.
	 */
	@ManagedProperty("#{sessionBean}")
	private SessionBean sessionBean;
	
	/**
	 * Inicializa la pantalla del detalle
	 */
	@PostConstruct
	public void init() {
		this.cantidadAlbumSeleccionada = 1;
	}
	
	/**
	 * Metodo que permite agregar el album seleccionado por el usuario al carrito de compras.
	 * @param artistaAlbumDTO {@link ArtistaAlbumDTO} objeto con el album seleccionado.
	 */
	public void agregarAlbumCarrito(ArtistaAlbumDTO artistaAlbumDTO) {
		LOGGER.info("Agregando album al carrito de compras..."+", Cantidad: "+ this.cantidadAlbumSeleccionada);
		
		CarritoAlbum carritosAlbumAgregado = this.carritoServiceImpl.guardarAlbumsCarrito(artistaAlbumDTO, this.sessionBean.getPersona().getCarrito(), cantidadAlbumSeleccionada);
		this.sessionBean.getPersona().getCarrito().getCarritosAlbum().add(carritosAlbumAgregado);
	
	}

	/**
	 * @return the cantidadAlbumSeleccionada
	 */
	public int getCantidadAlbumSeleccionada() {
		return cantidadAlbumSeleccionada;
	}

	/**
	 * @param cantidadAlbumSeleccionada the cantidadAlbumSeleccionada to set
	 */
	public void setCantidadAlbumSeleccionada(int cantidadAlbumSeleccionada) {
		this.cantidadAlbumSeleccionada = cantidadAlbumSeleccionada;
	}

	/**
	 * @return the logger
	 */
	public static Logger getLogger() {
		return LOGGER;
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
	
	
}
