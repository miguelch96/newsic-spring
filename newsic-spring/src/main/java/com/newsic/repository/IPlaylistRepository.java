package com.newsic.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.newsic.entity.Playlist;

public interface IPlaylistRepository extends CrudRepository<Playlist, Long> {
	

	Iterable<Playlist> findByNombreContaining(String texto);	
	@Query("select p from Playlist p where p.artista.artistaid=?1")
	Iterable<Playlist> findPlaylistsDelArtista(Long artistaid);
	

}
