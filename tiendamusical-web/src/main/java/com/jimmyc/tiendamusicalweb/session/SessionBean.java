/**
 * 
 */
package com.jimmyc.tiendamusicalweb.session;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.jimmyc.tiendamusicalentities.dto.ArtistaAlbumDTO;
import com.jimmyc.tiendamusicalentities.entities.Persona;

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
}
