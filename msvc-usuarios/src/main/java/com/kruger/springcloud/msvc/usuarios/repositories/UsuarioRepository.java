package com.kruger.springcloud.msvc.usuarios.repositories;

import org.springframework.data.repository.CrudRepository;

import com.kruger.springcloud.msvc.usuarios.models.entity.Usuario;

public interface UsuarioRepository extends CrudRepository<Usuario, Long>{
	

}
