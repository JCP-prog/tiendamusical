/**
 * 
 */
package com.jimmyc.tiendamusicalservices.service;

import com.jimmyc.tiendamusicalentities.entities.Persona;

/**
 * @author JimmyC
 * Clase que realiza la logica de negocio para el inicio de sesion de la persona
 */
public interface LoginService {

	/**
	 * Metodo que permite consultar un usuario que trata de ingersar a sesion en la tienda musical
	 * @param usuario {@link String} usuario capturado por la persona
	 * @param password {@link String} contraseña capturada por la persona
	 * @return {@link Persona} usuario encontrado en la base de datos
	 */
	Persona consultarUsuarioLogin(String usuario, String password);
}
