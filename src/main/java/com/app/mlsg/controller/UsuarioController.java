package com.app.mlsg.controller;

import java.util.ArrayList;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.mlsg.model.Usuario;
import com.app.mlsg.repository.UsuarioRepository;

@CrossOrigin("*")
@RestController
@RequestMapping("/api")
public class UsuarioController {

	@Autowired
	private UsuarioRepository usuarioRepository;

	@GetMapping("/usuarios")
	public ResponseEntity<List<Usuario>> getAllUsuarios(@RequestParam(required = false) String nombre) {
		try {
			List<Usuario> usuarios = new ArrayList<Usuario>();

			if (nombre == null) {
				usuarioRepository.findAll().forEach(usuarios::add);
			
			}
			return new ResponseEntity<>(usuarios, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
	
	

	@PostMapping("/usuarios")
	public ResponseEntity<Usuario> createUsuarios(@RequestBody Usuario usuario) {
		try {
			Usuario newUsuario = usuarioRepository.save(usuario);
			return new ResponseEntity<>(newUsuario, HttpStatus.CREATED);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	

	@PutMapping("/usuarios/{id}")
	public ResponseEntity<Usuario> updateUsuarios(@PathVariable("id") Integer id, @RequestBody Usuario usuario) {
		Optional<Usuario> usuarioData = usuarioRepository.findById(id);

		if (usuarioData.isPresent()) {
			Usuario _usuario = usuarioData.get();
			usuario.setId(_usuario.getId());
			return new ResponseEntity<>(usuarioRepository.save(usuario), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/usuarios/{idUsuario}")
	public ResponseEntity<HttpStatus> deleteUsuarios(@PathVariable("idUsuario") Integer id) {
		try {
			usuarioRepository.deleteById(id);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/usuarios")
	public ResponseEntity<HttpStatus> deleteAllUsuarios() {
		try {
			usuarioRepository.deleteAll();
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
