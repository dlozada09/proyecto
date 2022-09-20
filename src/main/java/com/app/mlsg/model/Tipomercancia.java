package com.app.mlsg.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Tipomercancia {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idtipomercancia")
	private Integer id;
	@Column(name = "descmercancia")
	private String descMercancia;
	
	public Tipomercancia() {
		
	}

	public Tipomercancia(String descMercancia) {
		super();
		this.descMercancia = descMercancia;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescMercancia() {
		return descMercancia;
	}

	public void setDescMercancia(String descMercancia) {
		this.descMercancia = descMercancia;
	}
	
	

}
