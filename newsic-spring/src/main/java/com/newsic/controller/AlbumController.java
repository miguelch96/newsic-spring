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

import com.newsic.entity.Album;
import com.newsic.service.IAlbumService;
import com.newsic.service.IArtistaService;
import com.newsic.service.ICancionService;
import com.newsic.service.IGeneroService;
import com.newsic.service.IPlaylistService;

@Controller
@RequestMapping("/albumes")
public class AlbumController {

	private static String PATH_PROYECTO = System.getProperty("user.dir");
	private static String PATH_IMGALBUMES = "/src/main/resources/static/images/imgalbumes/";
	private static String PATH_RUTABD = "/images/imgalbumes/";

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

	@GetMapping
	public String findAll(Model model) {
		model.addAttribute("albumes", albumService.findAll());
		model.addAttribute("generos", generoService.findAll());
		return "listalbumes";
	}

	@GetMapping("/buscarpornombre")
	public String buscarpornombre(Model model, @RequestParam(name = "filtro") String filtro) {
		if (filtro.isEmpty() || filtro.equals("")) {
			model.addAttribute("albumes", albumService.findAll());
		} else {
			model.addAttribute("albumes", albumService.findByNombreContaining(filtro));
		}
		model.addAttribute("generos", generoService.findAll());
		return "listalbumes";
	}

	@GetMapping("/{albumid}")
	public String findOne(@PathVariable Long albumid, Model model) {

		Album album=albumService.findOne(albumid);
		model.addAttribute("album", albumService.findOne(albumid));
		model.addAttribute("albumesdelartista", albumService.findByArtista(album.getArtista()));
		model.addAttribute("canciones", cancionService.findByAlbum(albumService.findOne(albumid)));
		model.addAttribute("generosalbum", generoService.generosdelAlbum(albumid));
		model.addAttribute("playlists",playlistService.findAll());
		return "album";
	}
	
	@GetMapping("/genero/{generoid}")
	public String albumesporgenero(@PathVariable Long generoid, Model model) {

		if(generoid==0)
			model.addAttribute("albumes", albumService.findAll());
		else
			model.addAttribute("albumes", albumService.findAlbumesDelGenero(generoid));
		
		model.addAttribute("generos", generoService.findAll());
		return "listalbumes";
	}

	@GetMapping("/new")
	public String newCourse(Model model) {
		model.addAttribute("artistas", artistaService.findAll());
		model.addAttribute("album", new Album());
		return "newalbum";
	}
	
	@PostMapping("/new")
	public String save(@Valid Album album, @RequestParam("imgalbum") MultipartFile imgalbum,BindingResult result,
			Model model) {
		try {
			if (result.hasErrors()) {
				model.addAttribute("message", result.toString());
				model.addAttribute("artistas", artistaService.findAll());
				return "newalbum";
			}

			
			if (imgalbum.isEmpty()) {
				album.setRutaimgalbum("");	
			}
			
			else
			{
				try {

					byte[] bytes = imgalbum.getBytes();
					String rutaimg = PATH_PROYECTO + PATH_IMGALBUMES + imgalbum.getOriginalFilename();
					Path path = Paths.get(rutaimg);
					Files.write(path, bytes);
					
					
					album.setRutaimgalbum(PATH_RUTABD+imgalbum.getOriginalFilename());
				
				} catch (IOException e) {
					model.addAttribute("message", e.getMessage());
					return "newalbum";
				}
			}
			
			this.albumService.save(album);
			return "redirect:/albumes";

		} catch (Exception e) {
			model.addAttribute("message",result.toString());
			model.addAttribute("artistas", artistaService.findAll());
			return "newalbum";
		}
	}

	
}