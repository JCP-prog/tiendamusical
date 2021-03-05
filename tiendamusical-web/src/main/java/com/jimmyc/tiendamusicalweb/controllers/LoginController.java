/**
 * 
 */
package com.jimmyc.tiendamusicalweb.controllers;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import com.jimmyc.tiendamusicalentities.entities.Persona;
import com.jimmyc.tiendamusicalservices.service.LoginService;
import com.jimmyc.tiendamusicalweb.utils.CommonUtils;

/**
 * @author JimmyC
 * Controlador que se encarga del flujo de la pantalla de login.xhtml.
 */

@ManagedBean
@ViewScoped
public class LoginController {
	/**
	 * Usuario capturado por la persona
	 */
	private String usuario;
	
	/**
	 * Contraseña capturada por la persona
	 */
	private String password;

	/**
	 * Propiedad de la logica del negocio inyectada con JSF y Spring
	 */
	@ManagedProperty("#{loginServiceImpl}") 
	private LoginService loginServiceImpl;
	
	@PostConstruct
	public void init() {
		System.out.println("Inicializando login...");
	}
	
	/**
	 * Metodo que permite a la persona ingresar a su pantalla de Home
	 */
	public void entrar() {
		
		Persona personaConsultada = this.loginServiceImpl.consultarUsuarioLogin(this.usuario, this.password);
		//if (this.usuario.equals("jimmyc") && this.password.equals("12345")) {
		if(personaConsultada != null)	{
			CommonUtils.mostrarMensaje(FacesMessage.SEVERITY_INFO, "¡EXITOSO!", "Bienvenido al Home :)");
		} else {
			CommonUtils.mostrarMensaje(FacesMessage.SEVERITY_ERROR, "¡UPSS!", "El usuario y/o contraseña son incorrectos :(");
		}
	}
	
	/**
	 * @return the usuario
	 */
	public String getUsuario() {
		return usuario;
	}

	/**
	 * @param usuario the usuario to set
	 */
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the loginServiceImpl
	 */
	public LoginService getLoginServiceImpl() {
		return loginServiceImpl;
	}

	/**
	 * @param loginServiceImpl the loginServiceImpl to set
	 */
	public void setLoginServiceImpl(LoginService loginServiceImpl) {
		this.loginServiceImpl = loginServiceImpl;
	}
	
}
