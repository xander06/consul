package com.kruger.springcloud.msvc.usuarios.controllers;

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

import com.kruger.springcloud.msvc.usuarios.models.entity.Usuario;
import com.kruger.springcloud.msvc.usuarios.services.UsuarioService;

@RestController  //los controladores manejan las peticiones del  usuario devuelve  json o xml 
public class UsuarioController {

	@Autowired UsuarioService service; //esto hace una inyeccion
	
	@GetMapping("/") //ruta base, si no quiero colocar da lo mismo
	public List<Usuario> listar(){
		return service.Listar();		
	}
	
	@GetMapping("/{id}")  //loq ue esta dentro de la llave es la variable
	public ResponseEntity<?> detalle(@PathVariable Long id) {  //signo pregunta de cualquier tipo tipo usuario o vacio sin contenido
		Optional<Usuario> usuarioOptional=service.porId(id);
		if(usuarioOptional.isPresent()) {
			return ResponseEntity.ok( usuarioOptional.get());  //
		}
		return ResponseEntity.notFound().build();
	}
	
	@PostMapping
	//@ResponseStatus(HttpStatus.CREATED)//respuesta 200  si se crea
	public ResponseEntity<?> crear (@RequestBody Usuario usuario) { //guarda  un suaurio siempre y cuando se cumplan o coincidan todos los atributos con la clase
		return ResponseEntity.status(HttpStatus.CREATED).body(service.guardar(usuario));
	}
	
	@PutMapping("/{id}") //para editar
	public ResponseEntity<?> editar (@RequestBody Usuario usuario, @PathVariable Long id){  //edita o actualiza un usuario reciviendo un paramettro
	Optional<Usuario> o = service.porId(id);
	if(o.isPresent()) {
		Usuario usuariodb=o.get();  //se obtiene el usuario de la basedd
		usuariodb.setNombre(usuario.getNombre());//se actualiza el usuario con el que nos viene del request
		usuariodb.setEmail(usuario.getEmail()); //se actualiza el email con lo que nos viene
		usuariodb.setPassword(usuario.getPassword()); //actualizar el password
	return ResponseEntity.status(HttpStatus.CREATED).body(service.guardar(usuariodb));
		}
	return ResponseEntity.notFound().build(); //si no no encontrado
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> eliminar(@PathVariable Long id){
	Optional<Usuario> o = service.porId(id);
	if(o.isPresent()) {
		service.eliminar(id);
		return ResponseEntity.noContent().build();
				}
	return ResponseEntity.notFound().build();
	}
}
