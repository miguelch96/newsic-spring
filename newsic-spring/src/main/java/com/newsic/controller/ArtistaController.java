package com.newsic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.newsic.service.IAlbumService;
import com.newsic.service.IArtistaService;
import com.newsic.service.ICancionService;


@Controller
@RequestMapping("/artistas")
public class ArtistaController {
	
	@Autowired
	private IArtistaService artistaService;
	@Autowired
	private IAlbumService albumService;
	@Autowired
	private ICancionService cancionService;
	
	@GetMapping
	public String findAll(Model model){
		model.addAttribute("artistas", artistaService.findAll());
		//model.addAttribute("artista",new Artista());
		return "listartistas";
	}
	
	@GetMapping("/{artistaid}")
	public String findOne(@PathVariable Long artistaid,Model model){
		model.addAttribute("albumes",albumService.findByArtista(artistaService.findOne(artistaid)));
		//model.addAttribute("canciones", cancionService.findByArtista(artistaService.findOne(artistaid)));
		model.addAttribute("artista",artistaService.findOne(artistaid));
		return "perfilartista";
	}
	
	@PostMapping("/new")
	public String newArtista(Model model){
		/*model.addAttribute("artistas",artistaService.findAll());
		model.addAttribute("artista",new Artista());*/
		return "signup";
	}

	
	

}
