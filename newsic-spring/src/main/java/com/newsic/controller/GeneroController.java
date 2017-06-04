package com.newsic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.newsic.service.IGeneroService;

@Controller
@RequestMapping("/generos")
public class GeneroController {

	@Autowired
	private IGeneroService generoService;
	
	@GetMapping("/generos")
	public String findAll(Model model){
		model.addAttribute("generos", generoService.findAll());
		return "listartistas";
	}
}
