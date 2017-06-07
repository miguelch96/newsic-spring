package com.newsic.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tipo_usuario")
public class TipoUsuario {
	
	@Id
	private Long tipousuarioid;
	private String nombre;
	
	
	public TipoUsuario()
	{
		
	}
	
	
	public Long getTipousuarioid() {
		return tipousuarioid;
	}
	public void setTipousuarioid(Long tipousuarioid) {
		this.tipousuarioid = tipousuarioid;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	

}
