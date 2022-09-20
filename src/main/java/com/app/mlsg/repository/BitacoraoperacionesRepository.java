package com.app.mlsg.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.app.mlsg.model.Bitacoraoperaciones;


public interface BitacoraoperacionesRepository extends CrudRepository<Bitacoraoperaciones, Integer> {
	
	List<Bitacoraoperaciones> findByNumeroGuia(String numeroGuia);
	List<Bitacoraoperaciones> findByNumeroOrden(String numeroOrden);
	Optional<Bitacoraoperaciones> findById(Integer id);

}
