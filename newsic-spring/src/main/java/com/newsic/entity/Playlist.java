package com.newsic.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "playlist")
public class Playlist {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long playlistid;
	
	@ManyToOne
	@JoinColumn(name="artistaid")
	private Artista artista;
	
	@Size(min=4,max=20,message="El nombre de la playlist debe tener entre 4 y 20 caracteres")
	private String nombre;
	
	private String descripcion;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date fechacreacion;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name="playlist_cancion",
			joinColumns={@JoinColumn(name="playlistid")},
			inverseJoinColumns={@JoinColumn(name="cancionid")})
	private List<Cancion> lstcanciones;
	
	public Playlist()
	{
	}

	public Long getPlaylistid() {
		return playlistid;
	}

	public void setPlaylistid(Long playlistid) {
		this.playlistid = playlistid;
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

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Date getFechacreacion() {
		return fechacreacion;
	}

	public void setFechacreacion(Date fechacreacion) {
		this.fechacreacion = fechacreacion;
	}

	public List<Cancion> getLstcanciones() {
		return lstcanciones;
	}

	public void setLstcanciones(List<Cancion> lstcanciones) {
		this.lstcanciones = lstcanciones;
	}


	
	
}
