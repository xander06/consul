package com.kruger.springcloud.msvc.cursos.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.kruger.springcloud.msvc.cursos.entity.Curso;
import com.kruger.springcloud.msvc.cursos.services.CursoService;

@RestController
public class CursoController {
	@Autowired
	private CursoService service;

	@GetMapping
	public ResponseEntity<List<Curso>> listar() {
		return ResponseEntity.ok(service.listar());
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> detalle(@PathVariable Long id) {
		Optional<Curso> o = service.porId(id);
		if (o.isPresent()) {
			return ResponseEntity.ok(o.get());
		}
		return ResponseEntity.notFound().build();
	}

	@PostMapping
	public ResponseEntity<?> crear(@RequestBody Curso curso) {
		Curso cursodb = service.guardar(curso);
		return ResponseEntity.status(HttpStatus.CREATED).body(cursodb);
	}

	@PutMapping("/{id}")
	public ResponseEntity<?> editar(@RequestBody Curso curso, @PathVariable Long id) {
		Optional<Curso> o = service.porId(id);
		if (o.isPresent()) {
			Curso cursodb = o.get();
			cursodb.setNombre(curso.getNombre());
			return ResponseEntity.status(HttpStatus.CREATED).body(service.guardar(cursodb));
		}
		return ResponseEntity.notFound().build();
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> eliminar(@PathVariable Long id) {
		Optional<Curso> o = service.porId(id);
		if (o.isPresent()) {
			service.eliminar(o.get().getId());
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.notFound().build();
	}
}
