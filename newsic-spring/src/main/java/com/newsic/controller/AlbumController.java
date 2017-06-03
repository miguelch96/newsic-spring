package com.newsic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.newsic.entity.Album;
import com.newsic.service.IAlbumService;
import com.newsic.service.IArtistaService;
import com.newsic.service.ICancionService;

@Controller
@RequestMapping("/album")
public class AlbumController {
	
	@Autowired
	private IAlbumService albumService;
	
	@Autowired
	private IArtistaService artistaService;

	@Autowired
	private ICancionService cancionService;
	
	@GetMapping("/albumes")
	public String findAll(Model model){
		model.addAttribute("albumes", albumService.findAll());
		model.addAttribute("album",new Album());
		return "Album";
			
	
	}
	
	
	@GetMapping("/{albumid}")
	public String findOne(@PathVariable Long artistaid,Model model){
		model.addAttribute("albumes",albumService.findByArtista(artistaService.findOne(artistaid)));
		//model.addAttribute("canciones", cancionService.findByArtista(artistaService.findOne(artistaid)));
		model.addAttribute("artista",artistaService.findOne(artistaid));
		return "perfilartista";
	}
	


}