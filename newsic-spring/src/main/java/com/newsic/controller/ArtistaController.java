package com.newsic.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.newsic.entity.Artista;
import com.newsic.service.IAlbumService;
import com.newsic.service.IArtistaService;
import com.newsic.service.ICancionService;
import com.newsic.service.IGeneroService;

@Controller
@RequestMapping("/artistas")
public class ArtistaController {

	@Autowired
	private IArtistaService artistaService;
	@Autowired
	private IAlbumService albumService;
	@Autowired
	private ICancionService cancionService;
	@Autowired
	private IGeneroService generoService;

	@GetMapping
	public String findAll(Model model) {
		model.addAttribute("artistas", artistaService.findAll());
		model.addAttribute("generos", generoService.findAll());
		return "listartistas";
	}

	@GetMapping("/{artistaid}")
	public String findOne(@PathVariable Long artistaid, Model model) {
		model.addAttribute("albumes", albumService.findByArtista(artistaService.findOne(artistaid)));
		model.addAttribute("canciones", cancionService.findByArtista(artistaid));
		model.addAttribute("artista", artistaService.findOne(artistaid));
		return "artista";
	}
	
	@GetMapping("/registro")
	public String irregistro(Model model) {
		return "signup";
	}


	@PostMapping("/registro")
	public String newArtista(Model model) {
		model.addAttribute("artista", new Artista());
		return "signup";
	}

	@PostMapping
	public String save(@Valid Artista artista, BindingResult result, Model model) {
		if (result.hasErrors()) {
			model.addAttribute("message", result.toString());
			return "signup";
		}
		this.artistaService.save(artista);
		return "signin";
	}

	@PostMapping("/login")
	public String irlogin(Model model) {
		return "signin";
	}

	@PostMapping("/loginusuario")
	public String login(@RequestParam(name = "email") String email, @RequestParam(name = "passwd") String passwd,
			Model model) {
		try {
			
			Artista artista=artistaService.findByEmail(email);
			if(artista==null)
			{
				model.addAttribute("message"
						+ "", "Email o contraseña incorrectos");
				return "signin";
			}
			else
			{
				if(artista.getPasswd().equals(passwd))
				{
					model.addAttribute("artistas", artistaService.findAll());
					model.addAttribute("generos", generoService.findAll());
					model.addAttribute("usuario", artista);
					return "redirect:/artistas";
					
				}
				
				else
				{
					model.addAttribute("message", "Contraseña incorrecta");
					return "signin";
				}
			}

		} catch (Exception exe) {
			model.addAttribute("message", "Contraseña incorrecta");
			return "signin";
		}

	}
}
