/**
 * 
 */
package com.jimmyc.tiendamusicalweb.session;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.jimmyc.tiendamusicalentities.dto.ArtistaAlbumDTO;
import com.jimmyc.tiendamusicalentities.entities.Persona;
import com.paypal.http.HttpResponse;
import com.paypal.orders.Order;

/**
 * @author JimmyC
 * Clase que mantendra la informacion en la sesion del usuario.
 */

@ManagedBean
@SessionScoped
public class SessionBean {

	/**
	 * Objeto Persona que se mantendra en la sesion
	 */
	private Persona persona;
	
	/**
	 * Objeto que contendra la informacion del detalle del album seleccionado por el cliente
	 */
	private ArtistaAlbumDTO artistaAlbumDTO;

	/** 
	 * total generado de la compra en sesion
	 */
	private float totalCompra;
	
	/**
	 * Orden generada por PayPal.
	 */
	private HttpResponse<Order> order;
	
	/**
	 * Numero del paso actual del proceso de compra
	 */
	private int paso;
	
	@PostConstruct
	public void init() {
		System.out.println("Creando Sesion...");
	}

	/**
	 * @return the persona
	 */
	public Persona getPersona() {
		return persona;
	}

	/**
	 * @param persona the persona to set
	 */
	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	/**
	 * @return the artistaAlbumDTO
	 */
	public ArtistaAlbumDTO getArtistaAlbumDTO() {
		return artistaAlbumDTO;
	}

	/**
	 * @param artistaAlbumDTO the artistaAlbumDTO to set
	 */
	public void setArtistaAlbumDTO(ArtistaAlbumDTO artistaAlbumDTO) {
		this.artistaAlbumDTO = artistaAlbumDTO;
	}

	/**
	 * @return the totalCompra
	 */
	public float getTotalCompra() {
		return totalCompra;
	}

	/**
	 * @param totalCompra the totalCompra to set
	 */
	public void setTotalCompra(float totalCompra) {
		this.totalCompra = totalCompra;
	}

	public void setOrder(HttpResponse<Order> response) {
		this.order = response;
	}

	/**
	 * @return the order
	 */
	public HttpResponse<Order> getOrder() {
		return order;
	}

	/**
	 * @return the paso
	 */
	public int getPaso() {
		return paso;
	}

	/**
	 * @param paso the paso to set
	 */
	public void setPaso(int paso) {
		this.paso = paso;
	}
}
