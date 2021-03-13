/**
 * 
 */
package com.jimmyc.tiendamusicalweb.controllers;

import java.io.IOException;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.jimmyc.tiendamusicalweb.utils.CommonUtils;

/**
 * @author JimmyC
 * Controlador que se encarga del flujo y acciones de la barra de navegacion.
 */

@ManagedBean
@ViewScoped
public class NavBarController {

	/**
	 * Objeto que permite mostrar los mensajes de LOG en la consola del servidor o en un archivo externo
	 */
	private static final Logger LOGGER = LogManager.getLogger(NavBarController.class);
	
	/**
	 * Inicializando la pantalla de carrito
	 */
	@PostConstruct
	public void init() {
		LOGGER.info("Inicializando pantalla carrito...");
	}
	
	/**
	 * Metodo que permite redireccionar a la pantalla del carrito de compras.
	 */
	public void redireccionar() {
		try {
			CommonUtils.redireccionar("/pages/cliente/carrito.xhtml");
		} catch (IOException e) {
			CommonUtils.mostrarMensaje(FacesMessage.SEVERITY_ERROR, "¡UPSS!", "Hubo un problema al ingresar a tu carrito, favor intentar mas tarde");
			e.printStackTrace();
		}
		
		
	}
}
