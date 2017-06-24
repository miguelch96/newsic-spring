package com.newsic.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.newsic.entity.Artista;
import com.newsic.entity.Usuario;

@Transactional
public interface IArtistaRepository extends CrudRepository<Artista, Long> {
	
	Artista findByNombreartistico(String name);
	Iterable<Artista> findByNombreContaining(String texto);
	Iterable<Artista> findByApellidoContaining(String texto);
	Artista findByUsuario(Usuario usuario);
	
	@Query(value = "call sp_artistasdelgenero(?1)", nativeQuery = true)
	Iterable<Artista> findArtistasDelGenero(Long generoid);
	
}
