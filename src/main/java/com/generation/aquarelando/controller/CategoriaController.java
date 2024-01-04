package com.generation.aquarelando.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.generation.aquarelando.model.Categoria;
import com.generation.aquarelando.repository.CategoriaRepository;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/categorias")
@CrossOrigin(origins = "*" ,allowedHeaders = "*")
public class CategoriaController {
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	// Buscando todas as categorias
	@GetMapping 
	public ResponseEntity<List<Categoria>>getAll(){
		return ResponseEntity.ok(categoriaRepository.findAll());
		
	}
	
	// Procurando por id
	@GetMapping("/{id}")
	public ResponseEntity<Categoria>getById(@PathVariable Long id){
		return categoriaRepository.findById(id)
		.map (resposta -> ResponseEntity.ok(resposta))
		.orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
		
	}
	
	// Procurando por nome
	@GetMapping("/nome/{nome}")
	public ResponseEntity<List<Categoria>> getByNome(@PathVariable String nome){
		return ResponseEntity.ok(categoriaRepository.findAllByNomeContainingIgnoreCase(nome));
	}
	
	// Criando categoria
	@PostMapping("/novo")//localhost:8080/categoria/new
	public ResponseEntity<Categoria> post (@Valid @RequestBody Categoria categoria) {
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(categoriaRepository.save(categoria));
	}
	
	//Atualizando categoria
	@PutMapping("/editar")//localhost:8080/categoria/edit
	public ResponseEntity<Categoria> put (@Valid @RequestBody Categoria categoria) {
		return categoriaRepository.findById(categoria.getId())
				.map(resposta -> ResponseEntity.status(HttpStatus.CREATED)
				.body(categoriaRepository.save(categoria)))
				.orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
	}
	
	//Deletando categoria
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@DeleteMapping("/deletar/{id}")//localhost:8080/categoria/delete
	public void delete(@PathVariable Long id) {
		Optional<Categoria> categoria =categoriaRepository.findById(id);
		
		if(categoria.isEmpty())
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		categoriaRepository.deleteById(id);
			
	}

}
