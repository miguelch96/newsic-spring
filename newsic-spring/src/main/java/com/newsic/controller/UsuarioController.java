package com.newsic.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {

	
	@GetMapping("/login")
	public String login(Model model){
		//model.addAttribute("artistas", artistaService.findAll());
		//model.addAttribute("artista",new Artista());
		return "signin";
	}
	
	
	@GetMapping("/registro")
	public String registro(Model model){
		//model.addAttribute("artistas", artistaService.findAll());
		//model.addAttribute("artista",new Artista());
		return "signup";
	}

}
