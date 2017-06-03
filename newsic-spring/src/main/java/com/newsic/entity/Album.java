package com.newsic.entity;

import java.sql.Blob;
import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "album")
public class Album {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long albumid;
	
	@ManyToOne
	@JoinColumn(name="artistaid")
	private Artista artista;
	
	
	@NotEmpty
	@Size(min=4,max=20,message="El nombre del album debe tener entre 4 y 20 caracteres")
	private String nombre;
	
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date fechapublicacion;
	

	private String rutaimgalbum;
	
	public Album()
	{
		
	}

	public Long getAlbumid() {
		return albumid;
	}

	public void setAlbumid(Long albumid) {
		this.albumid = albumid;
	}

	public Artista getArtista() {
		return artista;
	}

	public void setArtista(Artista artista) {
		this.artista = artista;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Date getFechapublicacion() {
		return fechapublicacion;
	}

	public void setFechapublicacion(Date fechapublicacion) {
		this.fechapublicacion = fechapublicacion;
	}

	public String getRutaimgalbum() {
		return rutaimgalbum;
	}

	public void setRutaimgalbum(String rutaimgalbum) {
		this.rutaimgalbum = rutaimgalbum;
	}

	
}
