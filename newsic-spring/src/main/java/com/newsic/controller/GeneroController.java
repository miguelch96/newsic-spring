package com.newsic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.newsic.service.IGeneroService;

@Controller
@RequestMapping("/generos")
public class GeneroController {

	@Autowired
	private IGeneroService generoService;
	
	@GetMapping
	public String findAll(Model model){
		model.addAttribute("generos", generoService.findAll());
		return "listgeneros";
	}
	
	@GetMapping("/buscarpornombre")
	public String buscarpornombre(Model model, @RequestParam(name = "filtro") String filtro) {
		if (filtro.isEmpty() || filtro.equals("")) {
			model.addAttribute("generos", generoService.findAll());
		} else {
			model.addAttribute("generos", generoService.findByNombreContaining(filtro));
		}
		return "listgeneros";
	}
}
