package com.gabriel.bookstore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.gabriel.bookstore.domain.Livro;
import com.gabriel.bookstore.domain.Opiniao;
import com.gabriel.bookstore.service.LivroService;

@RestController
public class LivroController {
	
	private LivroService service;

	@Autowired
	public LivroController(LivroService service) {
		this.service = service;
	}
	
	@GetMapping("/livros/tema/{tema}")
	public ResponseEntity<List<Livro>> obterPorTema(@PathVariable("tema") String tema) {
		List<Livro> livros = service.buscarLivroPorTema(tema);
		if(livros.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		else {
			return ResponseEntity.ok(livros);
		}
	}
	
	@PostMapping("/livros/opiniao")
	public ResponseEntity<String> cadastrarOpiniao(@RequestBody Opiniao opiniao) {
		service.adicionarOpiniao(opiniao);
		return ResponseEntity.ok("opinião cadastra");
	}
	
	@GetMapping("/livros/exibe-opinioes")
	public ResponseEntity<List<Opiniao>> exibirTodasOpinioes() {
		List<Opiniao> opinioes = service.exibeOpinioes();
		if (opinioes.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok(opinioes);
		
	}
	
}
