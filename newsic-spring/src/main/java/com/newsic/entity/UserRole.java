package com.newsic.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "userrole")
public class UserRole {

	@Id
	@GeneratedValue
	private Long id;

	private String role;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "iduser")
	private Usuario user;

	public UserRole(String role, Usuario user) {
		super();
		this.role = role;
		this.user = user;
	}

	public UserRole() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Usuario getUser() {
		return user;
	}

	public void setUser(Usuario user) {
		this.user = user;
	}

}
