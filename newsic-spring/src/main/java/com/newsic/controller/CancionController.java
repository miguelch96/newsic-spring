package com.newsic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.newsic.entity.Cancion;
import com.newsic.service.ICancionService;

@Controller
@RequestMapping("/cancion")
public class CancionController {
	
	@Autowired
	private ICancionService cancionService;
	
	@GetMapping("/canciones")
	public String findAll(Model model){
		model.addAttribute("canciones", cancionService.findAll());
		model.addAttribute("cancion",new Cancion());
		return "Cancion";
	}


}