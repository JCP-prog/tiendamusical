/**
 * 
 */
package com.jimmyc.tiendamusicaldata.dao;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.jimmyc.tiendamusicalentities.entities.CarritoAlbum;

/**
 * @author JimmyC
 * Interfaz que implementa los metodos genericos para el CRUD con Spring JPA hacia la tabla de carrito album.
 */
public interface CarritoAlbumDAO extends PagingAndSortingRepository<CarritoAlbum, Long> {

	
}
