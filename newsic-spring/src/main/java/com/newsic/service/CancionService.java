package com.newsic.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.newsic.entity.Album;
import com.newsic.entity.Cancion;
import com.newsic.entity.Genero;
import com.newsic.repository.ICancionRepository;

@Service
public class CancionService implements ICancionService {

	@Autowired
	private ICancionRepository cancionRepository;
	
	@Override
	public Iterable<Cancion> findAll() {
		return cancionRepository.findAll();
	}

	@Override
	public void save(Cancion cancion) {
		cancion.setReproducciones(0);
		cancionRepository.save(cancion);
	}

	@Override
	public Cancion findOne(Long id) {
		return cancionRepository.findOne(id);
	}

	@Override
	public void delete(Long id) {
		cancionRepository.delete(id);
	}
	
	@Override
	public Cancion findByNombre(String name) {
		return cancionRepository.findByNombre(name);
	}	

	@Override
	public Iterable<Cancion> findByNombreContaining(String texto) {
		return cancionRepository.findByNombreContaining(texto);
	}

	@Override
	public Iterable<Cancion> findByGenero(Genero genero) {
		return cancionRepository.findByGenero(genero);
	}


	@Override
	public Iterable<Cancion> findByAlbum(Album album) {
		return cancionRepository.findByAlbum(album);
	}

	@Override
	public Iterable<Cancion> findByArtista(Long artistaid) {
		return cancionRepository.findByArtista(artistaid);
	}

	@Override
	public Iterable<Cancion> MejoresCancionesDelArtista(Long artistaid) {
		return cancionRepository.MejoresCancionesDelArtista(artistaid);
	}


}
