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

import com.app.mlsg.model.Tipomercancia;
import com.app.mlsg.repository.TipomercanciaRepository;

@CrossOrigin("*")
@RestController
@RequestMapping("/api")
public class TipomercanciaController {
	
	@Autowired
	TipomercanciaRepository tipomercanciaRepository;
	
	
	@GetMapping("/tipomercancia")
	public ResponseEntity<List<Tipomercancia>> getAllTipomercancia(@RequestParam(required = false) String descMercancia) {
		try {
			List<Tipomercancia> tipomercancia = new ArrayList<Tipomercancia>();

			if (descMercancia == null) {
				tipomercanciaRepository.findAll().forEach(tipomercancia::add);
			} else {
				tipomercanciaRepository.findByDescMercancia(descMercancia).forEach(tipomercancia::add);
			}

			if (tipomercancia.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<>(tipomercancia, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@PostMapping("/tipomercancia")
	public ResponseEntity<Tipomercancia> createTipomercancia(@RequestBody Tipomercancia tipomercancia) {
		try {
			Tipomercancia newTipomercancia = tipomercanciaRepository.save(tipomercancia);
			return new ResponseEntity<>(newTipomercancia, HttpStatus.CREATED);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/tipomercancia/{id}")
	public ResponseEntity<Tipomercancia> updateTipomercancia(@PathVariable("id") Integer id, @RequestBody Tipomercancia tipomercancias) {
		Optional<Tipomercancia> tmercanciaData = tipomercanciaRepository.findById(id);

		if (tmercanciaData.isPresent()) {
			Tipomercancia _tmercancia = tmercanciaData.get();
			tipomercancias.setId(_tmercancia.getId());
			return new ResponseEntity<>(tipomercanciaRepository.save(tipomercancias), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/tipomercancia/{id}")
	public ResponseEntity<HttpStatus> deleteTipomercancia(@PathVariable("id") Integer id) {
		try {
			tipomercanciaRepository.findById(id);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	
}
	
	
