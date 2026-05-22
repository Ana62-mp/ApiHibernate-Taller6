package com.krakedev.apihibernate.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.krakedev.apihibernate.entidades.Pelicula;
import com.krakedev.apihibernate.repository.PeliculaRepository;

@Service
public class ServicioPelicula {
	private final PeliculaRepository peliculaRepository;

	public ServicioPelicula(PeliculaRepository peliculaRepository) {
		super();
		this.peliculaRepository = peliculaRepository;
	}
	
	public Pelicula crear(Pelicula pelicula) {
		//Save para guardar y acatualizar
		Pelicula pNueva = peliculaRepository.save(pelicula);
		return pNueva;
	}
	
	public List<Pelicula> listar(){
		return peliculaRepository.findAll();
	}
	
	public Pelicula buscarPorId(Long id) {
		// metodo find by id es siempre para buscar primary key, incluso si se llama cedula es findbyid
		return peliculaRepository.findById(id).orElse(null);
	}
	
	
	
	
}
