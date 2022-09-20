package com.app.mlsg.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.app.mlsg.model.Rol;

public interface RolRepository extends CrudRepository<Rol, Integer>{
	
	List<Rol> findByRol(String rol);
	Optional<Rol> findById(Integer id);
}
