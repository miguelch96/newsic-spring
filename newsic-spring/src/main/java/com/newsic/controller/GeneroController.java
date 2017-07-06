package com.newsic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.newsic.entity.Usuario;
import com.newsic.repository.UsuarioRepository;
import com.newsic.service.IAlbumService;
import com.newsic.service.IArtistaService;
import com.newsic.service.ICancionService;
import com.newsic.service.IGeneroService;

@Controller
@RequestMapping("/generos")
public class GeneroController {

	@Autowired
	private IArtistaService artistaService;
	@Autowired
	private IAlbumService albumService;
	@Autowired
	private ICancionService cancionService;
	@Autowired
	private IGeneroService generoService;
	@Autowired
	private UsuarioRepository userRepository;

	@GetMapping
	public String findAll(Model model) {
		model.addAttribute("generos", generoService.findAll());

		model.addAttribute("usuario", artistaService.findByUsuario(getUsuarioActual()));

		return "listgeneros";
	}

	@GetMapping("/buscarpornombre")
	public String buscarpornombre(Model model, @RequestParam(name = "filtro") String filtro) {
		if (filtro.isEmpty() || filtro.equals("")) {
			model.addAttribute("generos", generoService.findAll());
		} else {
			model.addAttribute("generos", generoService.findByNombreContaining(filtro));
		}
		model.addAttribute("usuario", artistaService.findByUsuario(getUsuarioActual()));

		return "listgeneros";
	}
	
	@GetMapping("{generoid}")
	public String vergenero(@PathVariable(name = "generoid") Long generoid,Model model) {
		model.addAttribute("usuario", artistaService.findByUsuario(getUsuarioActual()));

		return "redirect:/generos";
	}
	
	Usuario getUsuarioActual() {
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		return userRepository.findByUsername(user.getUsername());
	}
}
