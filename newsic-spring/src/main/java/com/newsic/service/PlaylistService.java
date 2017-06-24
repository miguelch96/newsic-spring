package com.newsic.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.newsic.entity.Cancion;
import com.newsic.entity.Playlist;
import com.newsic.repository.IPlaylistRepository;

@Service
public class PlaylistService implements IPlaylistService{

	@Autowired
	private IPlaylistRepository playlistRepository;
	@Override
	public Iterable<Playlist> findAll() {
		return playlistRepository.findAll();
	}

	@Override
	public void save(Playlist playlist) {
		playlistRepository.save(playlist);	
	}

	@Override
	public Playlist findOne(Long id) {
		return playlistRepository.findOne(id);
	}

	@Override
	public void delete(Long id) {
		playlistRepository.delete(id);	
	}

	@Override
	public Iterable<Playlist> findByNombreContaining(String texto) {
		return playlistRepository.findByNombreContaining(texto);
	}

	@Override
	public Iterable<Playlist> findPlaylistsDelArtista(Long artistaid) {
		return playlistRepository.findPlaylistsDelArtista(artistaid);
	}



}
