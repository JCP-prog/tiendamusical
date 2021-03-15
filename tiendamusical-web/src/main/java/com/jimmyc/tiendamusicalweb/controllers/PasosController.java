/**
 * 
 */
package com.jimmyc.tiendamusicalweb.controllers;

import java.io.IOException;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.jimmyc.tiendamusicalweb.session.SessionBean;
import com.jimmyc.tiendamusicalweb.utils.CommonUtils;

/**
 * @author JimmyC
 * Controlador que maneja el flujo de cambio de pasos en el proceso de compra de productos.
 */

@ManagedBean
@ViewScoped
public class PasosController {
	
	/**
	 * Objeto que permite mostrar los mensajes de LOG en la consola del servidor o en un archivo externo
	 */
	private static final Logger LOGGER = LogManager.getLogger(PasosController.class);
	
	/**
	 * Objeto que contiene la informacion en sesion del usuario
	 */
	@ManagedProperty("#{sessionBean}")
	private SessionBean sessionBean;
	
	@PostConstruct
	public void init() {
		LOGGER.info("Ingresando a Pasos Controller...");
	}
	
	/**
	 * Metodo que permite redireccionar al siguiente paso del proceso de compra del producto.
	 * @param url {@link String} url con la pantalla siguiente a mostrar
	 * @param paso {@link Integer} numero del paso siguiente de la compra.
	 */
	public void cambiarPaso(String url, int paso) {
		try {
			this.sessionBean.setPaso(paso);
			CommonUtils.redireccionar(url);
		} catch (IOException e) {
			CommonUtils.mostrarMensaje(FacesMessage.SEVERITY_ERROR, "UPS!", "Hubo un problema al tratar de ingresar al siguiente paso de la Compra, favor de intentarlo mas tarde");
			e.printStackTrace();
		}
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
