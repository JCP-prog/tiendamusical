/**
 * 
 */
package com.jimmyc.tiendamusicalweb.controllers;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import com.jimmyc.tiendamusicalentities.dto.ArtistaAlbumDTO;
import com.jimmyc.tiendamusicalservices.service.HomeService;

/**
 * @author JimmyC
 * Clase que controla el flujo de informacion para la pantalla de Home de cualquier tipo de usuario
 */

@ManagedBean
@ViewScoped
public class HomeController {

	/**
	 * Texto ingresado por el cliente en el buscador
	 */
	private String filtro;
	
	/**
	 * Lista obtenida a partir del filtro ingresado en el buscador
	 */
	private List<ArtistaAlbumDTO> artistasAlbumDTO;
	
	/**
	 * Se inyecta el objeto de Spring con JSF para obtener los metodos de logica de negocio del Home
	 */
	@ManagedProperty("#{homeServiceImpl}")
	private HomeService homeServiceImpl;
	
	/**
	 * Metodo que permite obtener los albums de los artistas encontrados en la base de datos
	 * con respecto al filtro ingresado por el cliente
	 */
	public void consultarAlbumsArtistasPorFiltro() {
		this.artistasAlbumDTO = this.homeServiceImpl.consultarAlbumsFiltro(this.filtro);
		
		if (this.artistasAlbumDTO != null) {
			this.artistasAlbumDTO.forEach(artistaAlbumDTO -> {
				System.out.println("Artista: "+ artistaAlbumDTO.getArtista().getNombre());
			});
		}
		
	}

	/**
	 * Metodo que inicializa la pantalla
	 */
	@PostConstruct
	public void init() {
		System.out.println("Inicializando Home");
	}

	/**
	 * @return the filtro
	 */
	public String getFiltro() {
		return filtro;
	}

	/**
	 * @param filtro the filtro to set
	 */
	public void setFiltro(String filtro) {
		this.filtro = filtro;
	}

	/**
	 * @return the artistasAlbumDTO
	 */
	public List<ArtistaAlbumDTO> getArtistasAlbumDTO() {
		return artistasAlbumDTO;
	}

	/**
	 * @param artistasAlbumDTO the artistasAlbumDTO to set
	 */
	public void setArtistasAlbumDTO(List<ArtistaAlbumDTO> artistasAlbumDTO) {
		this.artistasAlbumDTO = artistasAlbumDTO;
	}

	/**
	 * @return the homeServiceImpl
	 */
	public HomeService getHomeServiceImpl() {
		return homeServiceImpl;
	}

	/**
	 * @param homeServiceImpl the homeServiceImpl to set
	 */
	public void setHomeServiceImpl(HomeService homeServiceImpl) {
		this.homeServiceImpl = homeServiceImpl;
	}
}
