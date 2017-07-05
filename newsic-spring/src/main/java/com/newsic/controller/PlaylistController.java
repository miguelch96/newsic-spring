package com.newsic.controller;

import java.util.Calendar;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.newsic.entity.Artista;
import com.newsic.entity.Cancion;
import com.newsic.entity.Playlist;
import com.newsic.entity.Usuario;
import com.newsic.repository.UsuarioRepository;
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
	private UsuarioRepository userRepository;
	@Autowired
	private IPlaylistService playlistService;

	@GetMapping
	public String findAll(Model model) {
		Artista artista = artistaService.findByUsuario(getUsuarioActual());
		model.addAttribute("playlists", playlistService.findPlaylistsDelArtista(artista.getArtistaid()));
		model.addAttribute("generos", generoService.findAll());

		model.addAttribute("usuario", artistaService.findByUsuario(getUsuarioActual()));

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

		model.addAttribute("usuario", artistaService.findByUsuario(getUsuarioActual()));

		return "listplaylist";
	}

	@GetMapping("/{playlistid}")
	public String findOne(@PathVariable Long playlistid, Model model) {
		Playlist playlist = playlistService.findOne(playlistid);
		model.addAttribute("playlist", playlist);
		model.addAttribute("canciones", playlist.getLstcanciones());

		model.addAttribute("usuario", artistaService.findByUsuario(getUsuarioActual()));

		return "playlist";
	}

	@GetMapping("/add/{cadena}")
	public String addcancion(@PathVariable String cadena, Model model) {

		String[] id = cadena.split("-");
		Long playlistid = Long.parseLong(id[0]);
		Long cancionid = Long.parseLong(id[1]);

		Playlist playlist = playlistService.findOne(playlistid);

		for (Cancion _cancion : playlist.getLstcanciones()) {
			if (_cancion.getCancionid() == cancionid)
				return "redirect:/albumes";
		}

		playlist.getLstcanciones().add(cancionService.findOne(cancionid));
		playlistService.save(playlist);

		model.addAttribute("playlist", playlist);
		model.addAttribute("canciones", playlist.getLstcanciones());
		model.addAttribute("usuario", artistaService.findByUsuario(getUsuarioActual()));

		return "playlist";
	}

	Usuario getUsuarioActual() {
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		return userRepository.findByUsername(user.getUsername());
	}

	@GetMapping("/new")
	public String irnewplaylist(Model model) {
		model.addAttribute("playlist", new Playlist());
		model.addAttribute("usuario", artistaService.findByUsuario(getUsuarioActual()));
		return "newplaylist";
	}

	@PostMapping("/new")
	public String save(@Valid Playlist playlist, BindingResult result, Model model) {
		if (result.hasErrors()) {
			model.addAttribute("message", result.toString());
			return "newplaylist";
		}

		try {
			playlist.setArtista(artistaService.findByUsuario(getUsuarioActual()));
		
			this.playlistService.save(playlist);
			return "redirect:/playlist";
		} catch (Exception e) {
			model.addAttribute("message", e.getMessage());
			return "newplaylist";
		}
	}

}
