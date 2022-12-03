package com.kruger.springcloud.msvc.cursos.services;

import java.util.List;
import java.util.Optional;

import com.kruger.springcloud.msvc.cursos.entity.Curso;

public interface CursoService {
List<Curso> listar();
Optional<Curso> porId(Long Id);
Curso guardar (Curso curso);
void eliminar(Long Id);
}
