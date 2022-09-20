package com.app.mlsg.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.app.mlsg.model.Enrrutador;

public interface EnrrutadorRepository extends CrudRepository<Enrrutador, Integer>{
	
	List<Enrrutador> findByFechaRuta(String fechaRuta);
	Optional<Enrrutador> findById(Integer id);

}
