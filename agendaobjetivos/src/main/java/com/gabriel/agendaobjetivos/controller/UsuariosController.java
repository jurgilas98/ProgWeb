package com.gabriel.agendaobjetivos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.gabriel.agendaobjetivos.domain.TodosUsuarios;
import com.gabriel.agendaobjetivos.domain.Usuario;

//import java.util.ArrayList;

@RestController
public class UsuariosController {

	@Autowired
	private TodosUsuarios todosUsuarios;
	
	public UsuariosController(TodosUsuarios todosUsuarios) {
		this.todosUsuarios = todosUsuarios;
	}
	@GetMapping("/usuarios/nome/{nomeDoUsuario}")
	public ResponseEntity<List<Usuario>> obterPorNome(@PathVariable("nomeDoUsuario") String nome){
		List<Usuario> usuarios = todosUsuarios.findByNome(nome);
		if(usuarios.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok(usuarios);
	}
	
	@GetMapping("/usuarios/idade/{idadeDoUsuario}")
	public ResponseEntity<List<Usuario>> obterPorIdade(@PathVariable("idadeDoUsuario")Integer idade){
		List<Usuario> usuarios = todosUsuarios.porIdade(idade);
		if(usuarios.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok(usuarios);
	}
	
	//private List<Usuario> obterTodosUsuarios(){
	//		ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
	//		return usuarios;
	//}
	
	@PostMapping("/usuarios")
	public ResponseEntity<Usuario> cadastrarUsuario(@RequestBody Usuario usuario){
		this.todosUsuarios.save(usuario);
		return ResponseEntity.ok(usuario);
	}
}
