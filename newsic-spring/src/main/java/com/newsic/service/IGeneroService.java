package com.newsic.service;

import com.newsic.entity.Genero;

public interface IGeneroService {

	public Iterable<Genero> findAll();
	public void save(Genero cancion);
	public Genero findOne(Long id);
	public void delete(Long id);
	
	//REPOSITORY
	Genero findByNombre(String name);
	Iterable<Genero> findByNombreContaining(String texto);
}
