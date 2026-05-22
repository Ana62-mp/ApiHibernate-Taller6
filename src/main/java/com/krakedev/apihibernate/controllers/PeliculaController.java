package com.krakedev.apihibernate.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.krakedev.apihibernate.entidades.Pelicula;
import com.krakedev.apihibernate.services.ServicioPelicula;

@RestController
@RequestMapping("/peliculas")
public class PeliculaController {
	private final ServicioPelicula servicioP;

	public PeliculaController(ServicioPelicula servicioP) {
		super();
		this.servicioP = servicioP;
	}
	
	@PostMapping
	public ResponseEntity<?> crear(@RequestBody Pelicula pelicula) {
		return new ResponseEntity<>(servicioP.crear(pelicula), HttpStatus.CREATED);
	}
	
	@GetMapping
	public ResponseEntity<?> listar(){
		return new ResponseEntity<>(servicioP.listar(), HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> buscarPorId(@PathVariable Long id) {
		return new ResponseEntity<>(servicioP.buscarPorId(id), HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> actualizar(@PathVariable Long id, @RequestBody Pelicula pelicula) {
		return new ResponseEntity<>(servicioP.actualizar(id, pelicula), HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> eliminar(@PathVariable Long id) {
		return new ResponseEntity<>(servicioP.eliminar(id), HttpStatus.OK);
	}
	
	@GetMapping("/{genero}")
	public ResponseEntity<?> buscarPorGenero(@PathVariable String genero){
		return new ResponseEntity<>(servicioP.buscarPorGenero(genero), HttpStatus.OK);
	}
	
	@GetMapping("/{disponible}")
	public ResponseEntity<?> buscarPorDisponible(@PathVariable boolean disponible){
		return new ResponseEntity<>(servicioP.buscarPorDisponible(disponible), HttpStatus.OK);
	}
	
	
	
	
	
}
