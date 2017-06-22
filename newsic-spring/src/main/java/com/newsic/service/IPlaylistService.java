package com.newsic.service;

import com.newsic.entity.Playlist;

public interface IPlaylistService {
	
	public Iterable<Playlist> findAll();
	public void save(Playlist playlist);
	public Playlist findOne(Long id);
	public void delete(Long id);

	
	//REPO
	
	Iterable<Playlist> findByNombreContaining(String texto);	
	Iterable<Playlist> findPlaylistsDelArtista(Long artistaid);

}
