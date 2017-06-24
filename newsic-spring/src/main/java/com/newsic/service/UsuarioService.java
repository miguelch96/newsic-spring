package com.newsic.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


import com.newsic.entity.UserRole;
import com.newsic.repository.UsuarioRepository;

@Service
public class UsuarioService implements UserDetailsService {

	@Autowired
	private UsuarioRepository userRepository;

	
	// Se encargara de llamar a nuestro repository y se obtendra una entidad
		// user la cual se tendra que transformar a un userDetails

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub

		List<GrantedAuthority> authorities = new ArrayList<>();
		// Entity User: Creado en com.example.demo.entity
		com.newsic.entity.Usuario user = userRepository.findByUsername(username);

		if(user==null){
			throw new UsernameNotFoundException("No user found:"+username);
		}
		
		// Transformar los roles del user a objeto autorities
		authorities = buildAuthorities(user.getUserRole());

		return buildUser(user, authorities);

	}

	// Retorna un objeto tipo  User de  spring security, a partir de nuestro entity user (com.example.demo.entity)
	// Ademas recibi una lista de authorities que en realidad es nuestra entidad userrol
	private User buildUser(com.newsic.entity.Usuario user, List<GrantedAuthority> authorities) {
		return new User(user.getUsername(), user.getPassword(), user.isEnable(), true, true, true, authorities);
	}

	// Asigna nuestros roles a una lista de grantedautorities
	private List<GrantedAuthority> buildAuthorities(List<UserRole> userRoles) {
		List<GrantedAuthority> auths = new ArrayList<GrantedAuthority>();

		for (UserRole userRole : userRoles) {
			auths.add(new SimpleGrantedAuthority(userRole.getRole()));
		}
		return auths;
	}
}

