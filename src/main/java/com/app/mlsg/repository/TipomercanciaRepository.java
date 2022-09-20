package com.app.mlsg.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.app.mlsg.model.Tipomercancia;

public interface TipomercanciaRepository extends CrudRepository<Tipomercancia, Integer>{
	
	List<Tipomercancia> findByDescMercancia(String descMercancia);
	Optional<Tipomercancia> findById(Integer id);

}
