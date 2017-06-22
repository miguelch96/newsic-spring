package com.newsic.service;

import com.newsic.entity.Artista;

public interface IArtistaService {

	 
	public Iterable<Artista> findAll();
	public void save(Artista artista);	
	public Artista findOne(Long id);
	
		
	
	//REPOOSITORY
	Artista findByNombreartistico(String name);	
	Artista findByEmail(String email);
	Iterable<Artista> findByNombreContaining(String texto);
	Iterable<Artista> findByApellidoContaining(String texto);
	Iterable<Artista> findArtistasDelGenero(Long generoid);

}
