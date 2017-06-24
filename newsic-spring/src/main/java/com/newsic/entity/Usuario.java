package com.newsic.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "user")
public class Usuario {

	@Id
	private String username;

	@NotEmpty
	private String password;

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "user")
	private List<UserRole> userRole = new ArrayList<UserRole>();

	private boolean enable;

	public Usuario(String username, String password, boolean enable) {
		super();
		this.username = username;
		this.password = password;
		this.enable = enable;
	}

	public Usuario(String username, String password, boolean enable, List<UserRole> userRole) {
		super();
		this.username = username;
		this.password = password;
		this.enable = enable;
		this.userRole = userRole;
	}

	public Usuario() {

	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isEnable() {
		return enable;
	}

	public void setEnable(boolean enable) {
		this.enable = enable;
	}

	public List<UserRole> getUserRole() {
		return userRole;
	}

	public void setUserRole(List<UserRole> userRole) {
		this.userRole = userRole;
	}

}
