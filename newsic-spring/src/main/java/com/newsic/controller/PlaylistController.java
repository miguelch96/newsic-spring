package com.newsic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.newsic.entity.Playlist;
import com.newsic.service.IAlbumService;
import com.newsic.service.IArtistaService;
import com.newsic.service.ICancionService;
import com.newsic.service.IGeneroService;
import com.newsic.service.IPlaylistService;

@Controller
@RequestMapping("/playlist")
public class PlaylistController {
	
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
		model.addAttribute("playlists", playlistService.findAll());
		model.addAttribute("generos", generoService.findAll());
		return "listplaylist";
	}
	
	@GetMapping("/buscarpornombre")
	public String buscarpornombre(Model model, @RequestParam(name = "filtro") String filtro) {
		if (filtro.isEmpty() || filtro.equals("")) {
			model.addAttribute("playlists", playlistService.findAll());
		} else {
			model.addAttribute("playlists", playlistService.findByNombreContaining(filtro));
		}
		model.addAttribute("generos", generoService.findAll());
		return "listplaylist";
	}
	
	@GetMapping("/{playlistid}")
	public String findOne(@PathVariable Long playlistid, Model model) {
		Playlist playlist=playlistService.findOne(playlistid);
		model.addAttribute("playlist",playlist);
		model.addAttribute("canciones", playlist.getLstcanciones());
		//model.addAttribute("generosplaylist", generoService.generosdelArtista(artistaid));
		return "playlist";
	}
	
	@GetMapping("/add/{cadena}")
	public String addcancion(@PathVariable String cadena, Model model) {
		
		String[] id=cadena.split("-");
		Long playlistid=Long.parseLong(id[0]);
		Long cancionid=Long.parseLong(id[1]);
		
		Playlist playlist=playlistService.findOne(playlistid);
		playlist.getLstcanciones().add(cancionService.findOne(cancionid));
		playlistService.save(playlist);
		
		model.addAttribute("playlist",playlist);
		model.addAttribute("canciones", playlist.getLstcanciones());
		return "playlist";
	}


}
