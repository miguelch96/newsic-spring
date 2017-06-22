package com.newsic.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

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
import org.springframework.web.multipart.MultipartFile;

import com.newsic.entity.Artista;
import com.newsic.service.IAlbumService;
import com.newsic.service.IArtistaService;
import com.newsic.service.ICancionService;
import com.newsic.service.IGeneroService;

@Controller
@RequestMapping("/artistas")
public class ArtistaController {
	
	private static String PATH_PROYECTO = System.getProperty("user.dir");
	private static String PATH_IMGARTISTSA = "/src/main/resources/static/images/imgartistas/";
	private static String PATH_RUTABD = "../images/imgartistas/";

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

	@GetMapping("/buscarpornombre")
	public String buscarpornombre(Model model, @RequestParam(name = "filtro") String filtro) {
		if (filtro.isEmpty() || filtro.equals("")) {
			model.addAttribute("artistas", artistaService.findAll());
		} else {
			model.addAttribute("artistas", artistaService.findByNombreContaining(filtro));
		}
		model.addAttribute("generos", generoService.findAll());
		return "listartistas";
	}

	@GetMapping("/{artistaid}")
	public String findOne(@PathVariable Long artistaid, Model model) {
		model.addAttribute("albumes", albumService.findByArtista(artistaService.findOne(artistaid)));
		model.addAttribute("canciones", cancionService.findByArtista(artistaid));
		model.addAttribute("artista", artistaService.findOne(artistaid));
		model.addAttribute("generosartista", generoService.generosdelArtista(artistaid));
		model.addAttribute("mejoresalbumes", albumService.MejoresAlbumesDelArtista(artistaid));
		model.addAttribute("mejorescanciones", cancionService.MejoresCancionesDelArtista(artistaid));

		return "artista";
	}
	
	@GetMapping("/genero/{generoid}")
	public String albumesporgenero(@PathVariable Long generoid, Model model) {

		if(generoid==0)
			model.addAttribute("artistas", artistaService.findAll());
		else
			model.addAttribute("artistas", artistaService.findArtistasDelGenero(generoid));
		//model.addAttribute("artistas", artistaService.findArtistasDelGenero(generoid));
		model.addAttribute("generos", generoService.findAll());
		return "listartistas";
	}
	

	@GetMapping("/registro")
	public String irregistro(Model model) {
		model.addAttribute("artista", new Artista());
		return "signup";
	}

	@GetMapping("/login")
	public String irlogin(Model model) {
		return "signin";
	}

	@PostMapping("/registro")
	public String save(@Valid Artista artista,@RequestParam("imgperfil") MultipartFile imgperfil,
			BindingResult result, Model model) {
		if (result.hasErrors()) {
			model.addAttribute("message", result.toString());
			return "signup";
		}

		if (imgperfil.isEmpty()) {
			artista.setRutaimgperfil("");;

		}

		else {
			try {

				byte[] bytes = imgperfil.getBytes();
				String rutaimg = PATH_PROYECTO + PATH_IMGARTISTSA + imgperfil.getOriginalFilename();
				Path path = Paths.get(rutaimg);
				Files.write(path, bytes);

				artista.setRutaimgperfil(PATH_RUTABD + imgperfil.getOriginalFilename());


			} catch (IOException e) {
				model.addAttribute("message", e.getMessage());
				return "newalbum";
			}
		}

		this.artistaService.save(artista);
		return "signin";
	}

	@PostMapping("/login")
	public String login(@RequestParam(name = "email") String email, @RequestParam(name = "passwd") String passwd,
			Model model) {
		try {

			Artista artista = artistaService.findByEmail(email);
			if (artista == null) {
				model.addAttribute("message" + "", "Email o contraseña incorrectos");
				return "signin";
			} else {
				if (artista.getPasswd().equals(passwd)) {
					model.addAttribute("artistas", artistaService.findAll());
					model.addAttribute("generos", generoService.findAll());
					// model.addAttribute("usuario", artista);
					return "redirect:/artistas";

				}

				else {
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
