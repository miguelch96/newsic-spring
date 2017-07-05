package com.newsic.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.newsic.entity.Artista;
import com.newsic.repository.UsuarioRepository;
import com.newsic.service.IArtistaService;

@Controller
@RequestMapping("/")
public class LoginController {
	
	@Autowired
	private IArtistaService artistaService;
	
	@Autowired
	private UsuarioRepository userRepository;
	
	@GetMapping("/login")
	public String login(Model model, 
			@RequestParam(name="error", required=false) String error, 
			@RequestParam(name="logout",required=false) String logout){
		model.addAttribute("error", error);
		model.addAttribute("logout", logout);
		return "signin";
	}
	
	@GetMapping({"/loginsuccess","/"})
	public String loginCheck(Model model ){
		//Objeto User de Spring, getPrincipal es el usuario principal de la sesion
	    User user=(User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
		model.addAttribute("username", user.getUsername());
		com.newsic.entity.Usuario u = 	userRepository.findByUsername(user.getUsername());
		Artista a = artistaService.findByUsuario(u);
		model.addAttribute("logeado", a);
		
		
		return "redirect:/artistas";
	}
	
	@GetMapping("/registro")
	public String irregistro(Model model) {
		model.addAttribute("artista", new Artista());
		return "signup";
	}

	
	
}