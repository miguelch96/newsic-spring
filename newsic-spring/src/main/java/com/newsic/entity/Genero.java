package com.newsic.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "genero")
public class Genero {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long generoid;
	
	@NotEmpty
	@Size(min=2,max=20,message="El nombre del genero debe tener entre 2 y 20 caracteres")
	private String nombre;
	
	public Genero()
	{
		
	}

	public Long getGeneroid() {
		return generoid;
	}

	public void setGeneroid(Long generoid) {
		this.generoid = generoid;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	

	
	
	
}
