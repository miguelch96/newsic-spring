package com.newsic.service;

import com.newsic.entity.Album;

public interface IAlbumService {
 
	public Iterable<Album> findAll();
	public void save(Album album);
	public Album findOne(Long id);
	public void delete(Long id);
	
	
	//REPOSITORY
	Album findByNombre(String name);
	Iterable<Album> findByNombreContaining(String texto);
	Iterable<Album> findByArtistA(Long artistaid);
	Iterable<Album> findAlbumesDelGenero(Long generoid);
	Iterable<Album> MejoresAlbumesDelArtista(Long artistaid);

}
