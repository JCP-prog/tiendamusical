/**
 * 
 */
package com.jimmyc.tiendamusicaldata.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
//import org.springframework.data.repository.query.Param;

import com.jimmyc.tiendamusicalentities.entities.Persona;

/**
 * @author JimmyC
 * Clase DAO que realiza el CRUD con Spring JPA para la tabla de persona
 */


public interface PersonaDAO extends PagingAndSortingRepository<Persona, Long>{
	/**
	 * Metodo que permite consultar el usuario que trata de ingresar a sesion.
	 * @param usuario {@link String} Usuario capturado por la persona.
	 * @param password {@link String} Contraseña capturada por la persona.
	 * @return {@link Persona} Objeto con la persona encontrada.
	 */
	@Query("SELECT p FROM Persona p WHERE p.usuario = ?1 AND password = ?2")
	Persona findByUsuarioAndPassword(String usuario, String password);
	
	//@Query("SELECT p FROM Persona p WHERE p.usuario = :user AND password = :pass")
	//Persona findByUsuarioAndPassword(@Param("user") String usuario, @Param("pass") String password);
	
}
