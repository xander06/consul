package com.kruger.springcloud.msvc.cursos.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kruger.springcloud.msvc.cursos.entity.Curso;
import com.kruger.springcloud.msvc.cursos.repositories.CursoRepository;

@Service
public class CursoServiceImpl implements CursoService {

	@Autowired
	CursoRepository repository;

	@Override
	@Transactional(readOnly = true)
	public List<Curso> listar() {
		return (List<Curso>) repository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Curso> porId(Long Id) {
		// TODO Auto-generated method stub
		return repository.findById(Id);
	}

	@Override
	@Transactional
	public Curso guardar(Curso curso) {
		return repository.save(curso);
	}

	@Override
	@Transactional
	public void eliminar(Long Id) {
		// TODO Auto-generated method stub
		repository.deleteById(Id);
	}

}
