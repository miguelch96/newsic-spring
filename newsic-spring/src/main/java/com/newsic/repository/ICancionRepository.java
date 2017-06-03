package com.newsic.repository;

import org.springframework.data.repository.CrudRepository;

import com.newsic.entity.Album;
import com.newsic.entity.Artista;
import com.newsic.entity.Cancion;
import com.newsic.entity.Genero;


public interface ICancionRepository extends CrudRepository<Cancion, Long> {
	 
	Cancion findByNombre(String name);
	Iterable<Cancion> findByNombreContaining(String texto);
	Iterable<Cancion> findByGenero(Genero genero);
	Iterable<Cancion> findByArtista(Artista artista);
	Iterable<Cancion> findByAlbum(Album album);
}