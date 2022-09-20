package com.app.mlsg.model;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Enrrutador {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idenrrutador")
	private Integer id;
	@Column(name = "fecharuta")
	private String fechaRuta = LocalDateTime.now().toString();
	private String direccion;
	@Column(name = "complementodireccion")
	private String complementoDireccion;
	private String instruciones;
	private String peso;
	@Column(name = "gestion_de_paquetes_envios_idgestionenvio")
	private Integer GestiondPaquetesEnviosidGestionEnvio;
	@Column(name = "sedes_Origen")
	private Integer sedesOrigen;
	
	public Enrrutador() {
		
	}

	public Enrrutador(String fechaRuta, String direccion, String complementoDireccion, String instruciones, String peso,
			Integer gestiondPaquetesEnviosidGestionEnvio, Integer sedesOrigen) {
		super();
		this.fechaRuta = fechaRuta;
		this.direccion = direccion;
		this.complementoDireccion = complementoDireccion;
		this.instruciones = instruciones;
		this.peso = peso;
		GestiondPaquetesEnviosidGestionEnvio = gestiondPaquetesEnviosidGestionEnvio;
		this.sedesOrigen = sedesOrigen;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFechaRuta() {
		return fechaRuta;
	}

	public void setFechaRuta(String fechaRuta) {
		this.fechaRuta = fechaRuta;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getComplementoDireccion() {
		return complementoDireccion;
	}

	public void setComplementoDireccion(String complementoDireccion) {
		this.complementoDireccion = complementoDireccion;
	}

	public String getInstruciones() {
		return instruciones;
	}

	public void setInstruciones(String instruciones) {
		this.instruciones = instruciones;
	}

	public String getPeso() {
		return peso;
	}

	public void setPeso(String peso) {
		this.peso = peso;
	}

	public Integer getGestiondPaquetesEnviosidGestionEnvio() {
		return GestiondPaquetesEnviosidGestionEnvio;
	}

	public void setGestiondPaquetesEnviosidGestionEnvio(Integer gestiondPaquetesEnviosidGestionEnvio) {
		GestiondPaquetesEnviosidGestionEnvio = gestiondPaquetesEnviosidGestionEnvio;
	}

	public Integer getSedesOrigen() {
		return sedesOrigen;
	}

	public void setSedesOrigen(Integer sedesOrigen) {
		this.sedesOrigen = sedesOrigen;
	}
	

}
