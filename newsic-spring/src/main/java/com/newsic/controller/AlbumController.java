package com.newsic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.newsic.entity.Album;
import com.newsic.service.IAlbumService;

@Controller
@RequestMapping("/album")
public class AlbumController {
	
	@Autowired
	private IAlbumService albumService;
	
	@GetMapping("/albumes")
	public String findAll(Model model){
		model.addAttribute("albumes", albumService.findAll());
		model.addAttribute("album",new Album());
		return "Album";
	}
	
	


}