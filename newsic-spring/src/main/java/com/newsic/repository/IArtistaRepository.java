package com.newsic.repository;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;

import com.newsic.entity.Artista;

@Transactional
public interface IArtistaRepository extends CrudRepository<Artista, Long> {
	
	Artista findByNombreartistico(String name);
	Iterable<Artista> findByNombreContaining(String name);
	Iterable<Artista> findByNombreartisticoContaining(String texto);
	Artista findByEmail(String email);
	
}
