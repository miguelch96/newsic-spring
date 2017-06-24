package com.newsic.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.newsic.entity.Genero;

@Transactional
public interface IGeneroRepository extends CrudRepository<Genero, Long> {

	Genero findByNombre(String name);

	Iterable<Genero> findByNombreContaining(String texto);

	@Query(value = "call sp_generosdelartista(?1)", nativeQuery = true)
	Iterable<Genero> generosdelArtista(Long artistaid);

	@Query(value = "call sp_generosdelalbum(?1)", nativeQuery = true)
	Iterable<Genero> generosdelAlbum(Long albumid);

}
