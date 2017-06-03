package com.newsic.service;

import com.newsic.entity.Album;
import com.newsic.entity.Artista;

public interface IAlbumService {
 
	public Iterable<Album> findAll();
	public void save(Album album);
	public Album findOne(Long id);
	public void delete(Long id);
	
	
	//REPOSITORY
	public Album findByNombre(String name);
	public Iterable<Album> findByNombreContaining(String texto);
	public Iterable<Album> findByArtista(Artista artista);

}
