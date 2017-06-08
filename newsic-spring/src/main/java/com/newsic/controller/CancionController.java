package com.newsic.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.newsic.entity.Cancion;
import com.newsic.service.IArtistaService;
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
	
	
	@PostMapping("/newcancion")
	public String save(@Valid Cancion cancion, BindingResult result,Model model){
			if(result.hasErrors()){				
				model.addAttribute("message", result.toString());
				return "newcancion";
			}			
			this.cancionService.save(cancion);
			return "redirect:/canciones";			
	}


}