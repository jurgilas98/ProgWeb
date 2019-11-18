package com.gabriel.agendaobjetivos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.gabriel.agendaobjetivos.domain.TodosUsuarios;
import com.gabriel.agendaobjetivos.domain.Usuario;

@RestController
public class LoginController {
	
	@Autowired
	private TodosUsuarios todosUsuarios;
	
	
	@PostMapping("/cadastro")	
	public ResponseEntity<String> cadastrarObjetivo(@RequestBody Usuario usuario){
		todosUsuarios.save(usuario);
		return ResponseEntity.ok("Sucesso");
	}
	
	@PostMapping("/login")
	public ResponseEntity<String> validarLogin(@RequestBody Credenciais credenciais) {
		if(todosUsuarios.existe(credenciais)==null) {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Erro");
		}
		return ResponseEntity.ok("Sucesso!");
	}

	public LoginController(TodosUsuarios todosUsuarios) {
		super();
		this.todosUsuarios = todosUsuarios;
	}

	
	
}
