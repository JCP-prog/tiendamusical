/**
 * 
 */
package com.jimmyc.tiendamusicaldata.dao.impl;

import java.util.List;

import com.jimmyc.tiendamusicaldata.common.CommonDAO;
import com.jimmyc.tiendamusicaldata.dao.ArtistaDAO;
import com.jimmyc.tiendamusicalentities.dto.ArtistaAlbumDTO;
import com.jimmyc.tiendamusicalentities.entities.Artista;

/**
 * @author JimmyC
 * Clase que implementa el CRUD generico para realizar las transacciones a la tabla de artista
 */
public class ArtistaDAOImpl extends CommonDAO<Artista, ArtistaDAO> {

	public List<ArtistaAlbumDTO> consultarArtistaAlbumPorFiltro(String filtro){
		return this.repository.consultarArtistasAlbumsPorFiltro(filtro);
	}
}
