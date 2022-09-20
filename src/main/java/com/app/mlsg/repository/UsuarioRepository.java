package com.app.mlsg.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.app.mlsg.model.Usuario;

public interface UsuarioRepository extends CrudRepository<Usuario, Integer> {

	List<Usuario> findByTipoDocUsuario(String tipoDocUsuario);

	List<Usuario> findByNombre(String nombre);

	Optional<Usuario> findById(Integer id);

}
