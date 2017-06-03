package com.newsic.service;

import com.newsic.entity.Artista;

public interface IArtistaService {

	 
	public Iterable<Artista> findAll();

	public void save(Artista artista);
	
	public Artista findOne(Long id);
	
	//public void delete(int id);
		
	Artista findByNombreartistico(String name);
	
	Iterable<Artista> findByNombreartisticoContaining(String texto);
}
