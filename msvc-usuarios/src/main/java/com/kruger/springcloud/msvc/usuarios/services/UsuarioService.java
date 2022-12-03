package com.kruger.springcloud.msvc.usuarios.services;

import java.util.List;
import java.util.Optional;

import com.kruger.springcloud.msvc.usuarios.models.entity.Usuario;

public interface UsuarioService {
List<Usuario> Listar();
Optional<Usuario> porId(Long id); //Evitar que el Objeto sea nulo y que sea null point exceptional

Usuario guardar(Usuario usuario);//guardar para insertar o editar dependiendo del id y puede devolver el objeto no  devolver nada

void eliminar(Long id);  //para eliminar no devuelve ningun objeto

}
