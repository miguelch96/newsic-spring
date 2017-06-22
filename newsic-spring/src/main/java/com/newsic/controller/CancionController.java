package com.newsic.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.sound.sampled.UnsupportedAudioFileException;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.newsic.entity.Cancion;
import com.newsic.service.IAlbumService;
import com.newsic.service.IArtistaService;
import com.newsic.service.ICancionService;
import com.newsic.service.IGeneroService;

@Controller
@RequestMapping("/canciones")
public class CancionController {
	
	private static String PATH_PROYECTO = System.getProperty("user.dir");
	private static String PATH_CANCIONES = "/src/main/resources/static/audio/canciones/";
	private static String PATH_RUTABD = "../audio/canciones/";

	@Autowired
	private IArtistaService artistaService;

	@Autowired
	private IAlbumService albumService;

	@Autowired
	private ICancionService cancionService;

	@Autowired
	private IGeneroService generoService;
	
	@GetMapping
	public String findAll(Model model){
		model.addAttribute("canciones", cancionService.findAll());
		model.addAttribute("cancion",new Cancion());
		return "Cancion";
	}
	
	
	@GetMapping("/new")
	public String gotonewcancion(Model model){
		model.addAttribute("artistas", artistaService.findAll());
		model.addAttribute("albumes", albumService.findAll());
		model.addAttribute("generos", generoService.findAll());
		model.addAttribute("cancion",new Cancion());
		return "newcancion";
	}
	
	@PostMapping("/new")
	public String save(@Valid Cancion cancion,@RequestParam("archivocancion") MultipartFile archivocancion, BindingResult result,Model model) throws UnsupportedAudioFileException{
			if(result.hasErrors()){				
				model.addAttribute("message", result.toString());
				return "newcancion";
			}		
			
				try {

					byte[] bytes = archivocancion.getBytes();
					String rutacancion = PATH_PROYECTO + PATH_CANCIONES + archivocancion.getOriginalFilename();
					Path path = Paths.get(rutacancion);
					Files.write(path, bytes);
					
					/*
					File file = new File(rutacancion);
					AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(file);
					AudioFormat format = audioInputStream.getFormat();
					long frames = audioInputStream.getFrameLength();
					double durationInSeconds = (frames+0.0) / format.getFrameRate();
				    
				    int minutos=(int) (durationInSeconds/60);
				    
				    cancion.setDuracion(minutos+":"+(durationInSeconds-minutos*60));*/
					
					cancion.setDuracion("2:43");
					cancion.setRutacancion(PATH_RUTABD+archivocancion.getOriginalFilename());			

				} catch (IOException e) {
					model.addAttribute("message", e.getMessage());
					return "newcancion";
				}
			
			
			
			this.cancionService.save(cancion);
			return "redirect:/artistas";			
	}


}