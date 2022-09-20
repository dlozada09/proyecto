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

import com.app.mlsg.model.Bitacoraoperaciones;
import com.app.mlsg.repository.BitacoraoperacionesRepository;

@CrossOrigin("*")
@RestController
@RequestMapping("/api")
public class BitacoraoperacionesController {
	
	@Autowired
	BitacoraoperacionesRepository bitacoraoperacionesRepository;
	

	@GetMapping("/bitacoraoperaciones")
	public ResponseEntity<List<Bitacoraoperaciones>> getAllBitacorasoperacione(@RequestParam(required = false) String numeroGuia) {
		try {
			List<Bitacoraoperaciones> bitacoraop = new ArrayList<Bitacoraoperaciones>();

			if (numeroGuia == null) {
				bitacoraoperacionesRepository.findAll().forEach(bitacoraop::add);
			} else {
				bitacoraoperacionesRepository.findByNumeroGuia(numeroGuia).forEach(bitacoraop::add);
			}

			if (bitacoraop.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<>(bitacoraop, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@PostMapping("/bitacoraoperaciones")
	public ResponseEntity<Bitacoraoperaciones> createBitacoraoperaciones(@RequestBody Bitacoraoperaciones bitacoraop) {
		try {
			Bitacoraoperaciones newBitaco = bitacoraoperacionesRepository.save(bitacoraop);
			return new ResponseEntity<>(newBitaco, HttpStatus.CREATED);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/bitacoraoperaciones/{id}")
	public ResponseEntity<Bitacoraoperaciones> updateBitacoraoperaciones(@PathVariable("id") Integer id, @RequestBody Bitacoraoperaciones bitacoraop) {
		Optional<Bitacoraoperaciones> bitacoData = bitacoraoperacionesRepository.findById(id);

		if (bitacoData.isPresent()) {
			Bitacoraoperaciones _usuario = bitacoData.get();
			bitacoraop.setId(_usuario.getId());
			return new ResponseEntity<>(bitacoraoperacionesRepository.save(bitacoraop), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	
	@DeleteMapping("/bitacoraoperaciones/{id}")
	public ResponseEntity<HttpStatus> deleteBitacoraoperaciones(@PathVariable("id") Integer id) {
		try {
			bitacoraoperacionesRepository.deleteById(id);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	
}

