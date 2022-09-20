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

import com.app.mlsg.model.Rol;
import com.app.mlsg.repository.RolRepository;

@CrossOrigin("*")
@RestController
@RequestMapping("/api")
public class RolController {
	
	@Autowired
	RolRepository rolRepository;
	
	@GetMapping("/rol")
	public ResponseEntity<List<Rol>> getAllRol(@RequestParam(required = false) String rol) {
		try {
			List<Rol> usuarios = new ArrayList<Rol>();

			if (rol == null) {
				rolRepository.findAll().forEach(usuarios::add);
			} else {
				rolRepository.findByRol(rol).forEach(usuarios::add);
			}

			if (usuarios.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<>(usuarios, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
	
	@PostMapping("/rol")
	public ResponseEntity<Rol> createRol(@RequestBody Rol rol) {
		try {
			Rol newRol = rolRepository.save(rol);
			return new ResponseEntity<>(newRol, HttpStatus.CREATED);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("/rol/{id}")
	public ResponseEntity<Rol> updateRol(@PathVariable("id") Integer id, @RequestBody Rol rol) {
		Optional<Rol> rolData = rolRepository.findById(id);

		if (rolData.isPresent()) {
			Rol _rol = rolData.get();
			rol.setId(_rol.getId());
			return new ResponseEntity<>(rolRepository.save(rol), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	
	@DeleteMapping("/rol/{id}")
	public ResponseEntity<HttpStatus> deleteRol(@PathVariable("id") Integer id) {
		try {
			rolRepository.deleteById(id);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
}
