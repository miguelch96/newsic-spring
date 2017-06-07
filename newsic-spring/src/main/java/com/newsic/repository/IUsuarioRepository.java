package com.newsic.repository;

import org.springframework.data.repository.CrudRepository;

import com.newsic.entity.Usuario;

public interface IUsuarioRepository extends CrudRepository<Usuario,Long> {

	Usuario findByEmail(String email);
}
