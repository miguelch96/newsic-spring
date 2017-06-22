package com.newsic.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.newsic.entity.Artista;
import com.newsic.repository.IArtistaRepository;

@Service
public class ArtistaService implements IArtistaService {

	@Autowired
	private IArtistaRepository artistaRepository;

	@Override
	public Iterable<Artista> findAll() {
		return artistaRepository.findAll();
	}

	@Override
	public void save(Artista artista) {

		if (artista.getRutaimgperfil().equals(""))
			artista.setRutaimgperfil("../images/imgperfildefault.png");
		artistaRepository.save(artista);
	}

	@Override
	public Artista findOne(Long id) {
		return artistaRepository.findOne(id);
	}

	@Override
	public Artista findByNombreartistico(String name) {
		return artistaRepository.findByNombreartistico(name);
	}

	@Override
	public Artista findByEmail(String email) {
		return artistaRepository.findByEmail(email);
	}

	@Override
	public Iterable<Artista> findByNombreContaining(String texto) {
		return artistaRepository.findByNombreContaining(texto);
	}

	@Override
	public Iterable<Artista> findByApellidoContaining(String texto) {
		return artistaRepository.findByApellidoContaining(texto);
	}

	@Override
	public Iterable<Artista> findArtistasDelGenero(Long generoid) {
		return artistaRepository.findArtistasDelGenero(generoid);
	}



}
