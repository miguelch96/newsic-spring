package com.newsic.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.concurrent.ThreadLocalRandom;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.newsic.entity.Artista;
import com.newsic.repository.IAlbumRepository;
import com.newsic.repository.IArtistaRepository;
import com.newsic.repository.ICancionRepository;
import com.newsic.repository.IGeneroRepository;
import com.newsic.repository.IPlaylistRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class NewsicServiceTest {

	@Autowired
	protected IAlbumRepository albumRepository;

	@Autowired
	protected IArtistaRepository artistaRepository;

	@Autowired
	protected ICancionRepository cancionRepository;

	@Autowired
	protected IGeneroRepository generoRepository;

	@Autowired
	protected IPlaylistRepository playlistRepository;

	@Test
	public void shouldFindArtistaByEmail() throws Exception {
		/*
		Artista artista = this.artistaRepository.findByEmail("sergio@luyo");
		assertThat(artista.getNombre()).isEqualTo("Sergio");
		assertThat(artista.getApellido()).isEqualTo("Luyo");*/
	}

	@Test
	@Transactional
	public void shouldInsertArtista() {
/*
		Long cantidadinicial = this.artistaRepository.count();
		int randomNum = ThreadLocalRandom.current().nextInt(1, 10000 + 1);

		Artista artista = new Artista();
		artista.setNombre("test1");
		artista.setApellido("testapellido");
		artista.setEmail("emailtest" + randomNum);
		artista.setNombreartistico("testartistico");
		artista.setPasswd("12345");
		this.artistaRepository.save(artista);
		assertThat(artista.getArtistaid().longValue()).isNotEqualTo(0);

		Long cantidadfinal = this.artistaRepository.count();
		assertThat(cantidadfinal).isEqualTo(cantidadinicial + 1);*/
	}


}
