package com.newsic.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.newsic.entity.Artista;

@Transactional
public interface IArtistaRepository extends CrudRepository<Artista, Long> {
	
	Artista findByNombreartistico(String name);
	Artista findByEmail(String email);
	Iterable<Artista> findByNombreContaining(String texto);
	Iterable<Artista> findByApellidoContaining(String texto);

	@Query(value = "call sp_artistasdelgenero(?1)", nativeQuery = true)
	Iterable<Artista> findArtistasDelGenero(Long generoid);
}
