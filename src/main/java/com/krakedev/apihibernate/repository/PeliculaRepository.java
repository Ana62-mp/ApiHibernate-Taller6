package com.krakedev.apihibernate.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.krakedev.apihibernate.entidades.Pelicula;

public interface PeliculaRepository extends JpaRepository<Pelicula, Long>{
	
	//Select buscando pelicula con genero tal
	List<Pelicula> findByGenero(String genero);
	List<Pelicula> findByDisponible(boolean disponible);
	List<Pelicula> findByDirector(String director);
	
	//Para casos especiales si tenemos que hacer query
	@Query("SELECT p FROM Pelicula p WHERE p.genero = :genero AND p.duracion < :duracion")
	List<Pelicula> findByGeneroYDuracionMenorA(@Param("genero") String genero, @Param("duracion") int duracion);
}
