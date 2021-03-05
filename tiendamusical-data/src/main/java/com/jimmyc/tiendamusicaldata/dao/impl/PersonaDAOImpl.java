/**
 * 
 */
package com.jimmyc.tiendamusicaldata.dao.impl;

import com.jimmyc.tiendamusicaldata.common.CommonDAO;
import com.jimmyc.tiendamusicaldata.dao.PersonaDAO;
import com.jimmyc.tiendamusicalentities.entities.Persona;

/**
 * @author JimmyC
 * Clase que implementa el CRUD generico y las funciones de la interfaz de PersonaDAO
 */
public class PersonaDAOImpl extends CommonDAO<Persona, PersonaDAO> {
	
	/**
	 * Metodo que permite consultar una Persona por usuario y contraseña
	 * @param usuario {@link String} Usuario capturado por la persona.
	 * @param password {@link String} Contraseña capturado por la persona.
	 * @return {@link Persona} persona encontrada
	 */
	public Persona findUsuarioAndPassword(String usuario, String password) {
		return this.repository.findByUsuarioAndPassword(usuario, password);
	}
}
