package com.newsic.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.newsic.entity.Album;
import com.newsic.entity.Artista;
import com.newsic.repository.IAlbumRepository;

@Service
public class AlbumService implements IAlbumService{

	
	@Autowired
	private IAlbumRepository albumRepository;
	
	@Override
	public Iterable<Album> findAll() {
		return albumRepository.findAll();
	}

	@Override
	public void save(Album album) {

		albumRepository.save(album);
	}

	@Override
	public Album findOne(Long id) {
		return albumRepository.findOne(id);
	}

	@Override
	public void delete(Long id) {
		albumRepository.delete(id);
	}

	@Override
	public Album findByNombre(String name) {
		return albumRepository.findByNombre(name);
	}

	@Override
	public Iterable<Album> findByNombreContaining(String texto) {
		return albumRepository.findByNombreContaining(texto);
	}

	@Override
	public Iterable<Album> findByArtista(Artista artista) {
		return albumRepository.findByArtista(artista);
	}

}
