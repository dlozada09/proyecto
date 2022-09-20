package com.app.mlsg.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.app.mlsg.model.Marca;

public interface MarcaRepository extends CrudRepository<Marca, Integer> {

	List<Marca> findByNombreMarca(String nombreMarca);
	Optional<Marca> findById(Integer id);
}
