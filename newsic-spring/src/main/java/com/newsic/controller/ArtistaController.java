package com.newsic.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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
import com.newsic.entity.Usuario;
import com.newsic.repository.UsuarioRepository;
import com.newsic.service.IAlbumService;
import com.newsic.service.IArtistaService;
import com.newsic.service.ICancionService;
import com.newsic.service.IGeneroService;
import com.newsic.service.IPlaylistService;

@Controller
@RequestMapping("/artistas")
public class ArtistaController {

	private static String PATH_PROYECTO = System.getProperty("user.dir");
	private static String PATH_IMGARTISTSA = "/src/main/resources/static/images/imgartistas/";
	private static String PATH_RUTABD = "/images/imgartistas/";

	@Autowired
	private IArtistaService artistaService;
	@Autowired
	private IAlbumService albumService;
	@Autowired
	private ICancionService cancionService;
	@Autowired
	private IGeneroService generoService;
	
	@Autowired
	
	private IPlaylistService playlistService;

	@Autowired
	private UsuarioRepository userRepository;

	@GetMapping
	public String findAll(Model model) {
		model.addAttribute("artistas", artistaService.findAll());
		model.addAttribute("generos", generoService.findAll());
		
		model.addAttribute("usuario", artistaService.findByUsuario(getUsuarioActual()));

		return "listartistas";
	}
	
	@GetMapping("/profile")
	public String findAll(Long artistaid,Model model) {
		
		Artista artista=artistaService.findByUsuario(getUsuarioActual());
		
		model.addAttribute("miscanciones",cancionService.findByArtista(artista.getArtistaid()));
		model.addAttribute("misalbumes", albumService.findByArtistA(artista.getArtistaid()));
		model.addAttribute("misplaylist", playlistService.findPlaylistsDelArtista(artista.getArtistaid()));
		model.addAttribute("generos", generoService.findAll());
		
		model.addAttribute("usuario", artistaService.findByUsuario(getUsuarioActual()));

		return "profile";
	}

	@GetMapping("/buscarpornombre")
	public String buscarpornombre(Model model, @RequestParam(name = "filtro") String filtro) {
		if (filtro.isEmpty() || filtro.equals("")) {
			model.addAttribute("artistas", artistaService.findAll());
		} else {
			model.addAttribute("artistas", artistaService.findByNombreContaining(filtro));
		}
		model.addAttribute("generos", generoService.findAll());

		model.addAttribute("usuario", artistaService.findByUsuario(getUsuarioActual()));

		return "listartistas";
	}

	@GetMapping("/{artistaid}")
	public String findOne(@PathVariable Long artistaid, Model model) {
		model.addAttribute("albumes", albumService.findByArtistA(artistaid));
		model.addAttribute("canciones", cancionService.findByArtista(artistaid));
		model.addAttribute("artista", artistaService.findOne(artistaid));
		model.addAttribute("generosartista", generoService.generosdelArtista(artistaid));
		model.addAttribute("mejoresalbumes", albumService.MejoresAlbumesDelArtista(artistaid));
		model.addAttribute("mejorescanciones", cancionService.MejoresCancionesDelArtista(artistaid));

		model.addAttribute("usuario", artistaService.findByUsuario(getUsuarioActual()));
		;

		return "artista";
	}

	@GetMapping("/genero/{generoid}")
	public String albumesporgenero(@PathVariable Long generoid, Model model) {

		if (generoid == 0)
			model.addAttribute("artistas", artistaService.findAll());
		else
			model.addAttribute("artistas", artistaService.findArtistasDelGenero(generoid));
		model.addAttribute("generos", generoService.findAll());

		model.addAttribute("usuario", artistaService.findByUsuario(getUsuarioActual()));
		return "listartistas";
	}

	@GetMapping("/registro")
	public String irregistro(Model model) {
		model.addAttribute("artista", new Artista());
		return "signup";
	}
	
	@GetMapping("/editar")
	public String ireditar(Model model) {
		model.addAttribute("artista", artistaService.findByUsuario(getUsuarioActual()));
		return "signup";
	}

	@GetMapping("/login")
	public String irlogin(Model model) {
		return "signin";
	}

	@PostMapping("/registro")
	public String save(@Valid Artista artista, @RequestParam("imgperfil") MultipartFile imgperfil,
			@RequestParam("username") String username, @RequestParam("password") String password, BindingResult result,
			Model model) {
		if (result.hasErrors()) {
			model.addAttribute("message", result.toString());
			return "signup";
		}

		if (imgperfil.isEmpty()) {
			artista.setRutaimgperfil("");
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

		Usuario user = new Usuario(username, password, true);
		BCryptPasswordEncoder pe = new BCryptPasswordEncoder();
		user.setPassword(pe.encode(user.getPassword()));
		artista.setUsuario(user);

		this.artistaService.save(artista);
		return "redirect:/artistas";
	}
	
	
	Usuario getUsuarioActual() {
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		return userRepository.findByUsername(user.getUsername());
	}
	
	

}
