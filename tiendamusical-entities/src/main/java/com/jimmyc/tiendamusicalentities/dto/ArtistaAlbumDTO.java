/**
 * 
 */
package com.jimmyc.tiendamusicalentities.dto;

import com.jimmyc.tiendamusicalentities.entities.Album;
import com.jimmyc.tiendamusicalentities.entities.Artista;

/**
 * @author JimmyC
 * Clase DTO personalizado para obtener la informacion de los albums que el cliente busca 
 * a traves del filtro de busqueda del dashboard
 */
public class ArtistaAlbumDTO {

	/**
	 * Objeto que contiene la informacion del Artista
	 */
	private Artista artista;
	
	/**
	 * Objeto que contiene la informacion del Album
	 */
	private Album album;
	
	/**
	 * Constructor Default
	 */
	public ArtistaAlbumDTO() {
		super();
	}
	
	/** 
	 * Consutructor que inicializa la informacion consultada para la busqueda de albums
	 * @param album {@link Album} objeto que contiene el album del artista
	 * @param artista {@link Artista} objeto que contiene el artista (banda o solista)
	 */
	public ArtistaAlbumDTO(Album album, Artista artista) {
		this.album = album;
		this.artista = artista;
	}

	/**
	 * @return the artista
	 */
	public Artista getArtista() {
		return artista;
	}

	/**
	 * @param artista the artista to set
	 */
	public void setArtista(Artista artista) {
		this.artista = artista;
	}

	/**
	 * @return the album
	 */
	public Album getAlbum() {
		return album;
	}

	/**
	 * @param album the album to set
	 */
	public void setAlbum(Album album) {
		this.album = album;
	}
	
}
