package com.newsic.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Null;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "artista")
public class Artista {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long artistaid;

	@NotEmpty
	@Size(min = 4, max = 20, message = "El nombre debe tener entre 4 y 20 caracteres")
	private String nombre;

	@NotEmpty
	@Size(min = 4, max = 20, message = "El apellido debe tener entre 4 y 20 caracteres")
	private String apellido;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date fechanacimiento;

	@NotEmpty
	@Size(min = 4, max = 20, message = "El nombre artistico debe tener entre 4 y 20 caracteres")
	private String nombreartistico;

	private String rutaimgperfil;

	private String rutaimgportada;
	
	@NotEmpty
	@Size(min = 4, max = 20, message = "El email debe tener entre 4 y 20 caracteres")
	private String email;
	
	@NotEmpty
	@Size(min = 4, max = 20, message = "El password debe tener entre 4 y 20 caracteres")
	private String passwd;
	

	public Artista() {

	}
	
	

	public Artista(Long artistaid, String nombre, String apellido, Date fechanacimiento, String nombreartistico,
			String rutaimgperfil, String rutaimgportada, String email, String passwd) {
		super();
		this.artistaid = artistaid;
		this.nombre = nombre;
		this.apellido = apellido;
		this.fechanacimiento = fechanacimiento;
		this.nombreartistico = nombreartistico;
		this.rutaimgperfil = rutaimgperfil;
		this.rutaimgportada = rutaimgportada;
		this.email = email;
		this.passwd = passwd;
	}



	public Long getArtistaid() {
		return artistaid;
	}

	public void setArtistaid(Long artistaid) {
		this.artistaid = artistaid;
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

	public Date getFechanacimiento() {
		return fechanacimiento;
	}

	public void setFechanacimiento(Date fechanacimiento) {
		this.fechanacimiento = fechanacimiento;
	}

	public String getNombreartistico() {
		return nombreartistico;
	}

	public void setNombreartistico(String nombreartistico) {
		this.nombreartistico = nombreartistico;
	}

	public String getRutaimgperfil() {
		return rutaimgperfil;
	}

	public void setRutaimgperfil(String rutaimgperfil) {
		this.rutaimgperfil = rutaimgperfil;
	}

	public String getRutaimgportada() {
		return rutaimgportada;
	}

	public void setRutaimgportada(String rutaimgportada) {
		this.rutaimgportada = rutaimgportada;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	
	


	
	

}
