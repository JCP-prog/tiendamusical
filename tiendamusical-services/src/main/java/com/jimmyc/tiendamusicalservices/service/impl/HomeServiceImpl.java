/**
 * 
 */
package com.jimmyc.tiendamusicalservices.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jimmyc.tiendamusicaldata.dao.ArtistaDAO;
import com.jimmyc.tiendamusicalentities.dto.ArtistaAlbumDTO;
import com.jimmyc.tiendamusicalservices.service.HomeService;

/**
 * @author JimmyC
 * Clase que implementa los metodos de la logica de negocio de la interfaz de HomeService
 */

@Service
public class HomeServiceImpl implements HomeService {

	@Autowired
	private ArtistaDAO artistaDAOImpl;
	
	@Override
	public List<ArtistaAlbumDTO> consultarAlbumsFiltro(String filtro) {
		return this.artistaDAOImpl.consultarArtistasAlbumsPorFiltro(filtro);
	}

}
