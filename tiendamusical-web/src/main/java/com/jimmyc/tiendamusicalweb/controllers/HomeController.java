/**
 * 
 */
package com.jimmyc.tiendamusicalweb.controllers;

import java.io.IOException;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.jimmyc.tiendamusicalentities.dto.ArtistaAlbumDTO;
import com.jimmyc.tiendamusicalservices.service.HomeService;
import com.jimmyc.tiendamusicalweb.session.SessionBean;
import com.jimmyc.tiendamusicalweb.utils.CommonUtils;

/**
 * @author JimmyC
 * Clase que controla el flujo de informacion para la pantalla de Home de cualquier tipo de usuario
 */

@ManagedBean
@ViewScoped
public class HomeController {
	/**
	 * Objeto que permite mostrar los mensajes de LOG en la consola del servidor o en un archivo externo
	 */

	private static final Logger LOGGER = LogManager.getLogger(HomeController.class);
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
	 * Objeto que almacena informacion en sesion
	 */
	@ManagedProperty("#{sessionBean}")
	private SessionBean sessionBean;
	
	/**
	 * Metodo que inicializa la pantalla
	 */
	@PostConstruct
	public void init() {
		LOGGER.info("INFO");
		LOGGER.warn("WARN");
		LOGGER.error("ERROR");
		LOGGER.fatal("FATAL");
	}
	
	/**
	 * Metodo que permite obtener los albums de los artistas encontrados en la base de datos
	 * con respecto al filtro ingresado por el cliente
	 */
	public void consultarAlbumsArtistasPorFiltro() {
		this.artistasAlbumDTO = this.homeServiceImpl.consultarAlbumsFiltro(this.filtro);
		
		if (this.artistasAlbumDTO != null) {
			this.artistasAlbumDTO.forEach(artistaAlbumDTO -> {
				LOGGER.info("Artista: "+ artistaAlbumDTO.getArtista().getNombre());
			});
		}
		
	}
	
	/**
	 * Metodo que permite ver el detalle del album seleccionado por el cliente.
	 * @param artistaAlbumDTO {@link ArtistaAlbumDTO} objeto con el album seleccionado
	 */
	public void verDetalleAlbum(ArtistaAlbumDTO artistaAlbumDTO) {
		this.sessionBean.setArtistaAlbumDTO(artistaAlbumDTO);
		try {
			CommonUtils.redireccionar("/pages/cliente/detalle.xhtml");
		} catch (IOException e) {
			CommonUtils.mostrarMensaje(FacesMessage.SEVERITY_ERROR, "¡UPS!", "Hubo un error de formato en la pagina a ingresar. Favor de contactar con soporte.");
			e.printStackTrace();
		}
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

	/**
	 * @return the sessionBean
	 */
	public SessionBean getSessionBean() {
		return sessionBean;
	}

	/**
	 * @param sessionBean the sessionBean to set
	 */
	public void setSessionBean(SessionBean sessionBean) {
		this.sessionBean = sessionBean;
	}
}
