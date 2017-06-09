package com.newsic.repository;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;

import com.newsic.entity.Genero;

@Transactional
public interface IGeneroRepository extends CrudRepository<Genero, Long>{
	
	Genero findByNombre(String name);
	Iterable<Genero> findByNombreContaining(String texto);
}

