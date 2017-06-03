package com.newsic.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "cancion")
public class Cancion {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long cancionid;
	

	@NotEmpty
	@Size(min=4,max=20,message="El nombre del album debe tener entre 4 y 20 caracteres")
	private String nombre;
	
	private String duracion;
	
	private int reproducciones;
	
	@ManyToOne
	@JoinColumn(name="albumid")
	private Album album;
	
	@ManyToOne
	@JoinColumn(name="artistaid")
	private Artista artista;
	
	@ManyToOne
	@JoinColumn(name="generoid")
	private Genero genero;
	
	
	public Cancion()
	{
		
	}


	public Long getCancionid() {
		return cancionid;
	}


	public void setCancionid(Long cancionid) {
		this.cancionid = cancionid;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getDuracion() {
		return duracion;
	}


	public void setDuracion(String duracion) {
		this.duracion = duracion;
	}


	public int getReproducciones() {
		return reproducciones;
	}


	public void setReproducciones(int reproducciones) {
		this.reproducciones = reproducciones;
	}


	public Album getAlbum() {
		return album;
	}


	public void setAlbum(Album album) {
		this.album = album;
	}


	public Artista getArtista() {
		return artista;
	}


	public void setArtista(Artista artista) {
		this.artista = artista;
	}


	public Genero getGenero() {
		return genero;
	}


	public void setGenero(Genero genero) {
		this.genero = genero;
	}


	
	
		
}
