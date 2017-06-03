package com.newsic.repository;

import org.springframework.data.repository.CrudRepository;

import com.newsic.entity.Artista;


public interface IArtistaRepository extends CrudRepository<Artista, Long> {
	
	Artista findByNombreartistico(String name);
	Iterable<Artista> findByNombreartisticoContaining(String texto);
}
