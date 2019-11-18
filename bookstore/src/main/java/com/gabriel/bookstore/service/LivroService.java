package com.gabriel.bookstore.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.gabriel.bookstore.domain.Livro;
import com.gabriel.bookstore.domain.Opiniao;

@Service
public class LivroService {
		
	private List<Opiniao> opinioes = new ArrayList<Opiniao>();
	
	public List<Livro> buscarLivroPorTema(String tema){
		List<Livro> resultados = new ArrayList<Livro>();
		for(Livro livro: todosLivros()) {
			if(livro.comTema(tema)) {
				resultados.add(livro);
			}
		}
		return resultados;
	}
	
	private List<Livro> todosLivros(){
		List<Livro> livros = new ArrayList<Livro>();
		livros.add(new Livro("50 tons de azul", "comedia"));
		livros.add(new Livro("A morte do JS", "religiao"));
		livros.add(new Livro("Kotlin ou Java", "TI"));
		livros.add(new Livro("Palmeiras a espera de um mundial", "comedia"));
		return livros;
	}

	public void adicionarOpiniao(Opiniao opiniao) {
		opinioes.add(opiniao);
	}

	public List<Opiniao> exibeOpinioes() {
		
		return opinioes;
	}
	
}
