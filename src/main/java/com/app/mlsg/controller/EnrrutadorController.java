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

import com.app.mlsg.model.Enrrutador;
import com.app.mlsg.repository.EnrrutadorRepository;


@CrossOrigin("*")
@RestController
@RequestMapping("/api")
public class EnrrutadorController {
	
	@Autowired
	EnrrutadorRepository enrrutadorRepository;
	
	@GetMapping("/enrrutador")
	public ResponseEntity<List<Enrrutador>> getAllEnrrutador(@RequestParam(required = false) String fechaRuta) {
		try {
			List<Enrrutador> enrrutador = new ArrayList<Enrrutador>();

			if (fechaRuta == null) {
				enrrutadorRepository.findAll().forEach(enrrutador::add);
			} else {
				enrrutadorRepository.findByFechaRuta(fechaRuta).forEach(enrrutador::add);
			}

			if (enrrutador.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<>(enrrutador, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
	
	
	@PostMapping("/enrrutador")
	public ResponseEntity<Enrrutador> createEnrrutador(@RequestBody Enrrutador enrrutador) {
		try {
			Enrrutador newEnrrutador = enrrutadorRepository.save(enrrutador);
			return new ResponseEntity<>(newEnrrutador, HttpStatus.CREATED);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("/enrrutador/{id}")
	public ResponseEntity<Enrrutador> updateEnrrutador(@PathVariable("id") Integer id, @RequestBody Enrrutador enrrut) {
		Optional<Enrrutador> enrrutadorData = enrrutadorRepository.findById(id);

		if (enrrutadorData.isPresent()) {
			Enrrutador _enrrutador = enrrutadorData.get();
			enrrut.setId(_enrrutador.getId());
			return new ResponseEntity<>(enrrutadorRepository.save(enrrut), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/enrrutador/{id}")
	public ResponseEntity<HttpStatus> deleteEnrrutador(@PathVariable("id") Integer id) {
		try {
			enrrutadorRepository.deleteById(id);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
