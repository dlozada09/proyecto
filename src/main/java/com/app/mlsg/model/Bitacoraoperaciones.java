package com.app.mlsg.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Bitacoraoperaciones {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idpaquete")
	private Integer id;
	@Column(name = "numguia")
	private String numeroGuia;
	@ Column(name = "numorden")
	private String numeroOrden;
	@Column(name = "nombproducto")
	private String nombreProducto;
	@Column(name = "preciopaquete")
	private  Long precioPaquete;
	@Column(name = "estadoproducto")
	private String estadoProducto;
	@Column(name = "stockproducto")
	private Integer stockProducto;
	@Column(name = "tipoproducto")
	private String tipoProducto;
	@Column(name = "distancia")
	private String Distancia;
	@Column(name = "gestion_de_paquetes_envios_idgestionenvio")
	private Integer GestiondePaquetesEnviosidGestionEnvio;	
	
	public Bitacoraoperaciones() {
		
	}

	public Bitacoraoperaciones(String numeroGuia, String numeroOrden, String nombreProducto, Long precioPaquete,
			String estadoProducto, Integer stockProducto, String tipoProducto, String distancia,
			Integer gestiondePaquetesEnviosidGestionEnvio) {
		super();
		this.numeroGuia = numeroGuia;
		this.numeroOrden = numeroOrden;
		this.nombreProducto = nombreProducto;
		this.precioPaquete = precioPaquete;
		this.estadoProducto = estadoProducto;
		this.stockProducto = stockProducto;
		this.tipoProducto = tipoProducto;
		Distancia = distancia;
		GestiondePaquetesEnviosidGestionEnvio = gestiondePaquetesEnviosidGestionEnvio;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNumeroGuia() {
		return numeroGuia;
	}

	public void setNumeroGuia(String numeroGuia) {
		this.numeroGuia = numeroGuia;
	}

	public String getNumeroOrden() {
		return numeroOrden;
	}

	public void setNumeroOrden(String numeroOrden) {
		this.numeroOrden = numeroOrden;
	}

	public String getNombreProducto() {
		return nombreProducto;
	}

	public void setNombreProducto(String nombreProducto) {
		this.nombreProducto = nombreProducto;
	}

	public Long getPrecioPaquete() {
		return precioPaquete;
	}

	public void setPrecioPaquete(Long precioPaquete) {
		this.precioPaquete = precioPaquete;
	}

	public String getEstadoProducto() {
		return estadoProducto;
	}

	public void setEstadoProducto(String estadoProducto) {
		this.estadoProducto = estadoProducto;
	}

	public Integer getStockProducto() {
		return stockProducto;
	}

	public void setStockProducto(Integer stockProducto) {
		this.stockProducto = stockProducto;
	}

	public String getTipoProducto() {
		return tipoProducto;
	}

	public void setTipoProducto(String tipoProducto) {
		this.tipoProducto = tipoProducto;
	}

	public String getDistancia() {
		return Distancia;
	}

	public void setDistancia(String distancia) {
		Distancia = distancia;
	}

	public Integer getGestiondePaquetesEnviosidGestionEnvio() {
		return GestiondePaquetesEnviosidGestionEnvio;
	}

	public void setGestiondePaquetesEnviosidGestionEnvio(Integer gestiondePaquetesEnviosidGestionEnvio) {
		GestiondePaquetesEnviosidGestionEnvio = gestiondePaquetesEnviosidGestionEnvio;
	}
	
	

}
