package com.gabriel.agendaobjetivos.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.gabriel.agendaobjetivos.domain.Livro;
import com.gabriel.agendaobjetivos.domain.Opiniao;

@Service
public class LivrariaService {	
	
	private RestTemplate restTemplate; 
	private String url;
	
	public LivrariaService() {	
		this.restTemplate = new RestTemplate();
		this.url = "http://localhost:8081/livros";
	}

	public List<Livro> buscarPorTema(String tema) {
		String urlBusca = url + "/tema";		
		ResponseEntity<List> resposta = restTemplate.getForEntity(urlBusca, List.class);
		return resposta.getBody();
	}

	public String cadastrarOpiniao(Opiniao opiniao) {
		String urlCadastro = url + "/opiniao";
		ResponseEntity<String> resposta = restTemplate.postForEntity(urlCadastro, opiniao, String.class);
		return resposta.getBody();
	}
	
	public List<Opiniao> lerTodasOpinioes(){
		String urlBusca = url + "/exibe-opinioes";
		ResponseEntity<Opiniao []> resposta = restTemplate.getForEntity(urlBusca, Opiniao [].class);
		return Arrays.asList(resposta.getBody());
		
	}
	
}
