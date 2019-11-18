package com.gabriel.agendaobjetivos.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.gabriel.agendaobjetivos.domain.Objetivo;
import com.gabriel.agendaobjetivos.domain.TodosObjetivos;

@RestController
public class ObjetivosController {

	private TodosObjetivos todosObjetivos;

	
	@Autowired
	public ObjetivosController(TodosObjetivos to) {
		// TODO Auto-generated constructor stub
		this.todosObjetivos = to;
	}
	
	
	@PostMapping("/objetivos")	
	public ResponseEntity<String> cadastrarObjetivo(@RequestBody Objetivo objetivo){
		this.todosObjetivos.save(objetivo);
		return ResponseEntity.ok("Sucesso");
	}
	
	@GetMapping("/objetivos/data/{data}")
	public ResponseEntity<List<Objetivo>> listarPorData(@PathVariable("data")String data){
		List<Objetivo> objetivoPorData = new ArrayList<Objetivo>();
		objetivoPorData = this.todosObjetivos.ate(LocalDate.parse(data));
		if(objetivoPorData.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok(objetivoPorData);
	}
}
