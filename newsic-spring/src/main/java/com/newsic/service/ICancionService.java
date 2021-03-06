package com.newsic.service;

import com.newsic.entity.Album;
import com.newsic.entity.Cancion;
import com.newsic.entity.Genero;

public interface ICancionService {
	
	
	public Iterable<Cancion> findAll();
	public void save(Cancion cancion);
	public Cancion findOne(Long id);
	public void delete(Long id);
	 
	
	//REPOSITORY
	public Cancion findByNombre(String name);
	public Iterable<Cancion> findByNombreContaining(String texto);
	public Iterable<Cancion> findByGenero(Genero genero);
	public Iterable<Cancion> findByAlbum(Album album);
	public Iterable<Cancion> findByArtista(Long artistaid);
	Iterable<Cancion> MejoresCancionesDelArtista(Long artistaid);
}
