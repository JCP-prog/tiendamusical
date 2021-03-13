/**
 * 
 */
package com.jimmyc.tiendamusicalentities.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author JimmyC
 * Clase que representa entidades de facturas a realizar la compra de un carrito.
 */

@Entity
@Table(name="factura")
public class Factura extends Common{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idFactura")
	private Long idFactura;
	
	@Column(name = "orderId", length = 50, nullable = false)
	private String orderId;
	
	@Column(name = "impuestoTotal", nullable = false)
	private double impuestoTotal;
	
	@Column(name = "envio", nullable = false)
	private double envio;
	
	@Column(name = "envioDescuento", nullable = false)
	private double envioDescuento;
	
	@Column(name = "handling", nullable = false)
	private double handling;
	
	@Column(name = "total", nullable = false)
	private double total;
	
	@Column(name = "direccion", length = 500, nullable = false)
	private String direccion;
	
	@Column(name = "codigoPostal", length = 5, nullable = false)
	private String codigoPostal;
	
	@Column(name = "pais", length = 45, nullable = false)
	private String pais;
	
	@Column(name = "ciudad", length = 45, nullable = false)
	private String ciudad;
	
	@Column(name = "divisa", length = 45, nullable = false)
	private String 	divisa;
	
	@ManyToOne
	@JoinColumn(name="idPersona")
	private Persona persona;
	
	@OneToMany(mappedBy = "factura")
	private List<CarritoAlbum> carritosAlbum;

	/**
	 * @return the idFactura
	 */
	public Long getIdFactura() {
		return idFactura;
	}

	/**
	 * @param idFactura the idFactura to set
	 */
	public void setIdFactura(Long idFactura) {
		this.idFactura = idFactura;
	}

	/**
	 * @return the orderId
	 */
	public String getOrderId() {
		return orderId;
	}

	/**
	 * @param orderId the orderId to set
	 */
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	/**
	 * @return the impuestoTotal
	 */
	public double getImpuestoTotal() {
		return impuestoTotal;
	}

	/**
	 * @param impuestoTotal the impuestoTotal to set
	 */
	public void setImpuestoTotal(double impuestoTotal) {
		this.impuestoTotal = impuestoTotal;
	}

	/**
	 * @return the envio
	 */
	public double getEnvio() {
		return envio;
	}

	/**
	 * @param envio the envio to set
	 */
	public void setEnvio(double envio) {
		this.envio = envio;
	}

	/**
	 * @return the envioDescuento
	 */
	public double getEnvioDescuento() {
		return envioDescuento;
	}

	/**
	 * @param envioDescuento the envioDescuento to set
	 */
	public void setEnvioDescuento(double envioDescuento) {
		this.envioDescuento = envioDescuento;
	}

	/**
	 * @return the handling
	 */
	public double getHandling() {
		return handling;
	}

	/**
	 * @param handling the handling to set
	 */
	public void setHandling(double handling) {
		this.handling = handling;
	}

	/**
	 * @return the total
	 */
	public double getTotal() {
		return total;
	}

	/**
	 * @param total the total to set
	 */
	public void setTotal(double total) {
		this.total = total;
	}

	/**
	 * @return the direccion
	 */
	public String getDireccion() {
		return direccion;
	}

	/**
	 * @param direccion the direccion to set
	 */
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	/**
	 * @return the codigoPostal
	 */
	public String getCodigoPostal() {
		return codigoPostal;
	}

	/**
	 * @param codigoPostal the codigoPostal to set
	 */
	public void setCodigoPostal(String codigoPostal) {
		this.codigoPostal = codigoPostal;
	}

	/**
	 * @return the pais
	 */
	public String getPais() {
		return pais;
	}

	/**
	 * @param pais the pais to set
	 */
	public void setPais(String pais) {
		this.pais = pais;
	}

	/**
	 * @return the ciudad
	 */
	public String getCiudad() {
		return ciudad;
	}

	/**
	 * @param ciudad the ciudad to set
	 */
	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	/**
	 * @return the divisa
	 */
	public String getDivisa() {
		return divisa;
	}

	/**
	 * @param divisa the divisa to set
	 */
	public void setDivisa(String divisa) {
		this.divisa = divisa;
	}

	/**
	 * @return the persona
	 */
	public Persona getPersona() {
		return persona;
	}

	/**
	 * @param persona the persona to set
	 */
	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	/**
	 * @return the carritoAlbum
	 */
	public List<CarritoAlbum> getCarritosAlbum() {
		return carritosAlbum;
	}

	/**
	 * @param carritoAlbum the carritoAlbum to set
	 */
	public void setCarritosAlbum(List<CarritoAlbum> carritosAlbum) {
		this.carritosAlbum = carritosAlbum;
	}
}
