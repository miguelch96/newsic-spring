package com.newsic.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
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

	@NotEmpty
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date fechanacimiento;

	@Size(min = 4, max = 20, message = "El nombre artisticos debe tener entre 4 y 20 caracteres")
	private String nombreartistico;

	private String rutaimgperfil;

	private String rutaimgportada;

	/*
	 * @OneToOne(cascade = CascadeType.ALL)
	 * 
	 * @JoinColumn(name = "usuarioid") private Usuario usuario;
	 */

	public Artista() {

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

}
