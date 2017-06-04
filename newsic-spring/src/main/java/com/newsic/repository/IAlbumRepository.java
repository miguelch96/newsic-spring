package com.newsic.repository;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;

import com.newsic.entity.Album;
import com.newsic.entity.Artista;

@Transactional
public interface IAlbumRepository extends CrudRepository<Album,Long> {

	Album findByNombre(String name);
	Iterable<Album> findByNombreContaining(String texto);
	Iterable<Album> findByArtista(Artista artista);
}
