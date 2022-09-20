package com.app.mlsg.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idusuario")
	private Integer id;

	@Column(name = "tipodocusuario")
	private String tipoDocUsuario;

	@Column(name = "numdocumento")
	private String numeroDocumento;

	@Column(name = "nomusuario")
	private String nombre;

	@Column(name = "apeusuario")
	private String apellido;

	@Column(name = "telusuario")
	private String telefono;

	@Column(name = "emailusuario")
	private String email;

	@Column(name = "passusuario")
	private String password;

	@Column(name = "estadousuario")
	private String estado;

	@Column(name = "created_at")
	private String createdAt = LocalDateTime.now().toString();

	@Column(name = "updated_at")
	private String updatedAt = LocalDateTime.now().toString();

	@Column(name = "rol_idrol")
	private Integer idRol;

	@Column(name = "permisos_usuario_idpermiso")
	private Integer idPermiso;

	public Usuario() {
	}

	public Usuario(String tipoDocUsuario, String numeroDocumento, String nombre, String apellido, String telefono,
			String email, String password, String estado, String createdAt, String updatedAt, Integer idRol,
			Integer idMarca, Integer idPermiso) {
		super();
		this.tipoDocUsuario = tipoDocUsuario;
		this.numeroDocumento = numeroDocumento;
		this.nombre = nombre;
		this.apellido = apellido;
		this.telefono = telefono;
		this.email = email;
		this.password = password;
		this.estado = estado;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.idRol = idRol;
		this.idMarca = idMarca;
		this.idPermiso = idPermiso;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTipoDocUsuario() {
		return tipoDocUsuario;
	}

	public void setTipoDocUsuario(String tipoDocUsuario) {
		this.tipoDocUsuario = tipoDocUsuario;
	}

	public String getNumeroDocumento() {
		return numeroDocumento;
	}

	public void setNumeroDocumento(String numeroDocumento) {
		this.numeroDocumento = numeroDocumento;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}

	public String getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(String updatedAt) {
		this.updatedAt = updatedAt;
	}

	public Integer getIdRol() {
		return idRol;
	}

	public void setIdRol(Integer idRol) {
		this.idRol = idRol;
	}

	public Integer getIdMarca() {
		return idMarca;
	}

	public void setIdMarca(Integer idMarca) {
		this.idMarca = idMarca;
	}

	public Integer getIdPermiso() {
		return idPermiso;
	}

	public void setIdPermiso(Integer idPermiso) {
		this.idPermiso = idPermiso;
	}

	
}
