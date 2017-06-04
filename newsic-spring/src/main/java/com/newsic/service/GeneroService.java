package com.newsic.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.newsic.entity.Genero;
import com.newsic.repository.IGeneroRepository;

@Service
public class GeneroService implements IGeneroService{

	
	@Autowired
	private IGeneroRepository generoRepository;
	
	@Override
	public Iterable<Genero> findAll() {
		return generoRepository.findAll();
	}

	@Override
	public void save(Genero cancion) {
		generoRepository.save(cancion);
	}

	@Override
	public Genero findOne(Long id) {
		return generoRepository.findOne(id);
	}

	@Override
	public void delete(Long id) {
		 generoRepository.delete(id);
	}

	@Override
	public Genero findByNombre(String name) {
		return generoRepository.findByNombre(name);
	}

	@Override
	public Iterable<Genero> findByNombreContaining(String texto) {
		return generoRepository.findByNombreContaining(texto);
	}

}
