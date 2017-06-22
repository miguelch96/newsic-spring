package com.newsic.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.newsic.entity.Album;
import com.newsic.entity.Artista;

@Transactional
public interface IAlbumRepository extends CrudRepository<Album,Long> {

	Album findByNombre(String name);
	Iterable<Album> findByNombreContaining(String texto);
	Iterable<Album> findByArtista(Artista artista);
	
	@Query(value = "call sp_albumesdelgenero(?1)", nativeQuery = true)
	Iterable<Album> findAlbumesDelGenero(Long generoid);
	
	@Query(value = "call sp_mejores4albumesdelartista(?1)", nativeQuery = true)
	Iterable<Album> MejoresAlbumesDelArtista(Long artistaid);
}
