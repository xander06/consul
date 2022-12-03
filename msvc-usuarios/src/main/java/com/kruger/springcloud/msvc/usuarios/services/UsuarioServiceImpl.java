package com.kruger.springcloud.msvc.usuarios.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kruger.springcloud.msvc.usuarios.models.entity.Usuario;
import com.kruger.springcloud.msvc.usuarios.repositories.UsuarioRepository;

@Service //es un estereotipo component
public class UsuarioServiceImpl implements UsuarioService {
	
	@Autowired
	private UsuarioRepository repository;
	
	@Override
	@Transactional(readOnly = true) //siempre del  sprinboot 
	public List<Usuario> Listar() {
		return (List<Usuario>)repository.findAll(); //se hace el cast del list
	}

	@Override
	@Transactional(readOnly = true) //siempre del  sprinboot, es consulta por eso solo readonly
	public Optional<Usuario> porId(Long id) {
		return repository.findById(id);
	}

	@Override
	@Transactional 
	public Usuario guardar(Usuario usuario) {
		return repository.save(usuario);
	}

	@Override
	@Transactional 
	public void eliminar(Long id) {
		repository.deleteById(id);
	}

}
