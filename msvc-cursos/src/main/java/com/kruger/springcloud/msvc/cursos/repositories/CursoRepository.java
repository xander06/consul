package com.kruger.springcloud.msvc.cursos.repositories;
import org.springframework.data.repository.CrudRepository;


import com.kruger.springcloud.msvc.cursos.entity.Curso;

public interface CursoRepository extends CrudRepository<Curso, Long> {
	

}
