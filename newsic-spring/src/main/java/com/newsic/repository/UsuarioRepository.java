package com.newsic.repository;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;

import com.newsic.entity.Usuario;

@Transactional
public interface UsuarioRepository extends CrudRepository<Usuario,String> {

	public Usuario findByUsername(String username);
}
