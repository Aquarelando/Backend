package com.generation.aquarelando.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.generation.aquarelando.model.Usuario;
import com.generation.aquarelando.model.UsuarioLogin;
import com.generation.aquarelando.repository.UsuarioRepository;

@RestController
@RequestMapping("/usuarios")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UsuarioController {
	
	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@GetMapping("/all")
	public ResponseEntity<List<Usuario>> getAll(){
		
		return ResponseEntity.ok(UsuarioRepository.findAll());
		
	}
	@PostMapping("/logar")
	public ResponseEntity<UsuarioLogin> autenticarUsuario(@ResquestBody Optional<UsuarioLogin> usuarioLogin){
		
		return usuarioService.cadastrarUsuario(usuario)
				.map(resposta -> ResponseEntity.status(HttpStatus.OK).body(resposta))
				.orElse(ResponseEntity.status(HttpStatus.UNAUTHORIZED).build());
		
	}
	
	@PostMapping("/cadastrar")
	public usuarioService.cadastrarUsuario(usuario)
	.map(resposta -> ResponseEntity.status(HttpStatus.CREATED).body(resposta))
	.orElse(ResponseEntity.status(HttpStatus.BAD_REQUEST).build());
	
	}

	@PuMapping("/atualizar")
	public ResponseEntity<Usuario> putUsuario (@)Valid @RequestBody Usuario usuario){
		.map(resposta -> ResponseEntity.status(HttpStatus.OK).body(resposta)
		.orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());		
	}
	
	}
