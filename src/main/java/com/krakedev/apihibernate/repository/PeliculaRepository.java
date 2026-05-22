package com.krakedev.apihibernate.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.krakedev.apihibernate.entidades.Pelicula;

public interface PeliculaRepository extends JpaRepository<Pelicula, Long>{
	
	//Select buscando pelicula con genero tal
	List<Pelicula> findByGenero(String genero);
	List<Pelicula> findByDisponible(boolean disponible);
	List<Pelicula> findByDirector(String director);
	
}
