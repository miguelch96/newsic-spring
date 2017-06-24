package com.newsic.service;

import com.newsic.entity.Artista;
import com.newsic.entity.Usuario;

public interface IArtistaService {

	 
	public Iterable<Artista> findAll();
	public void save(Artista artista);	
	public Artista findOne(Long id);
	
		
	
	//REPOOSITORY
	Artista findByNombreartistico(String name);	
	Iterable<Artista> findByNombreContaining(String texto);
	Iterable<Artista> findByApellidoContaining(String texto);
	Iterable<Artista> findArtistasDelGenero(Long generoid);
	Artista findByUsuario(Usuario usuario);

}
