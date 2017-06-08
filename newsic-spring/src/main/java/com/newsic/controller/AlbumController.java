package com.newsic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.newsic.service.IAlbumService;
import com.newsic.service.ICancionService;
import com.newsic.service.IGeneroService;

@Controller
@RequestMapping("/albumes")
public class AlbumController {
	
	@Autowired
	private IAlbumService albumService;
	
	@Autowired
	private ICancionService cancionService;
	
	@Autowired
	private IGeneroService generoService;
	
	@GetMapping
	public String findAll(Model model){
		model.addAttribute("albumes", albumService.findAll());
		model.addAttribute("generos", generoService.findAll());
		return "listalbumes";
	}
	
	@GetMapping("/{albumid}")
	public String findOne(@PathVariable Long albumid,Model model){
		
		model.addAttribute("album",albumService.findOne(albumid));
		model.addAttribute("canciones", cancionService.findByAlbum(albumService.findOne(albumid)));
		return "album";
	}
	


}