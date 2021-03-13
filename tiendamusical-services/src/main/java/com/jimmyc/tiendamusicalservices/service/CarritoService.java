/**
 * 
 */
package com.jimmyc.tiendamusicalservices.service;

import com.jimmyc.tiendamusicalentities.dto.ArtistaAlbumDTO;
import com.jimmyc.tiendamusicalentities.entities.Carrito;
import com.jimmyc.tiendamusicalentities.entities.CarritoAlbum;

/**
 * @author JimmyC
 * Interfaz que define los metodos de logica de negocio para el carrito de compras.
 */
public interface CarritoService {

	/**
	 * Metodo que permite guardar los Albums a comprar en el carrito de compras.
	 * @param artistaAlbumDTO {@link ArtistaAlbumDTO} objeto con la informacion del album en el carrito.
	 * @param carrito {@link Carrito} objeto con la informacion del carrito del usuario.
	 * @param cantidadAlbumSeleccionada {@link Integer} cantidad seleccionada del album por el usuario.
	 */
	CarritoAlbum guardarAlbumsCarrito(ArtistaAlbumDTO artistaAlbumDTO, Carrito carrito, int cantidadAlbumSeleccionada);
	
	/**
	 * Metodo que permite calcular el total de la compra
	 * @param carrito {@link Carrito} objeto con la informacion del carrito a calcular.
	 * @return {@link Float} total calculado.
	 */
	float calcularTotal(Carrito carrito);
	
	/**
	 * Metodo que permite eliminar un album del carrito
	 * @param carritoAlbum {@link CarritoAlbum} objeto con el album del carrito a eliminar
	 */
	void eliminarAlbumCarrito(CarritoAlbum carritoAlbum);
	
	/**
	 * Metodo que permite actualizar la cantidad del album a comprar en el carrito
	 * @param carritoAlbum {@link CarritoAlbum} objeto con el album a actualizar en el carrito
	 * @param carrito {@link Carrito} carrito de compras de la persona
	 */
	float actualizarAlbumCantidad(CarritoAlbum carritoAlbum, Carrito carrito);
}
