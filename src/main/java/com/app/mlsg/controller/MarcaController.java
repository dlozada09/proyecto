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

import com.app.mlsg.model.Marca;
import com.app.mlsg.repository.MarcaRepository;

@CrossOrigin("*")
@RestController
@RequestMapping("/api")
public class MarcaController {
	@Autowired
	 MarcaRepository marcaRepository;

	@GetMapping("/marca")
	public ResponseEntity<List<Marca>> getAllMarca(@RequestParam(required = false) String marca) {
		try {
			List<Marca> marcas = new ArrayList<Marca>();

			if (marca == null) {
				marcaRepository.findAll().forEach(marcas::add);
			} else {
				marcaRepository.findByNombreMarca(marca).forEach(marcas::add);
			}

			if (marcas.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<>(marcas, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
	
	
	@PostMapping("/marca")
	public ResponseEntity<Marca> createMarca(@RequestBody Marca marca) {
		try {
			Marca newMarca = marcaRepository.save(marca);
			return new ResponseEntity<>(newMarca, HttpStatus.CREATED);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("/marca/{id}")
	public ResponseEntity<Marca> updateMarca(@PathVariable("id") Integer id, @RequestBody Marca mar) {
		Optional<Marca> marcaData = marcaRepository.findById(id);
		if (marcaData.isPresent()) {
			Marca _marca = marcaData.get();
			mar.setId(_marca.getId());
			return new ResponseEntity<>(marcaRepository.save(mar), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	
	@DeleteMapping("/marca/{id}")
	public ResponseEntity<HttpStatus> deleteMarca(@PathVariable("id") Integer id) {
		try {
			marcaRepository.deleteById(id);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
