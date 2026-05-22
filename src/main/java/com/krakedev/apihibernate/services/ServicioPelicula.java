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
	
	public Pelicula actualizar(Long id, Pelicula pelicula) {
		Pelicula existeP=buscarPorId(id);
		if(existeP!=null) {
			return peliculaRepository.save(pelicula);			
		}
		return null;
	}
	
	public boolean eliminar(Long id) {
		Pelicula existeP=buscarPorId(id);
		if(existeP!=null) {
			peliculaRepository.deleteById(id);
			return true;
		}
		return false;
	}
	
	public List<Pelicula> buscarPorGenero(String genero){
		return peliculaRepository.findByGenero(genero);
	}
	public List<Pelicula> buscarPorDisponible(boolean disponible){
		return peliculaRepository.findByDisponible(disponible);
	}
	
	
	
	
	
}
