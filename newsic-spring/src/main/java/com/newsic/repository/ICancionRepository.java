package com.newsic.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.newsic.entity.Album;
import com.newsic.entity.Cancion;
import com.newsic.entity.Genero;

@Transactional
public interface ICancionRepository extends CrudRepository<Cancion, Long> {

	
	Cancion findByNombre(String name);
	Iterable<Cancion> findByNombreContaining(String texto);
	Iterable<Cancion> findByGenero(Genero genero);
	Iterable<Cancion> findByAlbum(Album album);
	
	@Query("select c from Cancion c where c.album.artista.artistaid=?1")
	Iterable<Cancion> findByArtista(Long artistaid);
	
	@Query(value = "call sp_mejores4cancionesdelartista(?1)", nativeQuery = true)
	Iterable<Cancion> MejoresCancionesDelArtista(Long artistaid);
}

