package com.gabriel.agendaobjetivos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.gabriel.agendaobjetivos.domain.Livro;
import com.gabriel.agendaobjetivos.domain.Opiniao;
import com.gabriel.agendaobjetivos.service.LivrariaService;

@RestController
public class LivrosController {
	
	private final LivrariaService service;
	
	@Autowired
	public LivrosController(LivrariaService service) {
		this.service = service;
	}
	
	@GetMapping("/livros/tema/{tema}")
	public ResponseEntity<List<Livro>> buscarPorTema(@PathVariable("tema") String tema){
		List<Livro> livros = service.buscarPorTema(tema);
		if(livros.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		else {
			return ResponseEntity.ok(livros);
		}
	}
	
	@PostMapping("/livros/opiniao")
	public ResponseEntity<String> cadastrarOpiniao(@RequestBody Opiniao opiniao){
		String resposta = service.cadastrarOpiniao(opiniao);
		return ResponseEntity.ok(resposta);
	}
}
