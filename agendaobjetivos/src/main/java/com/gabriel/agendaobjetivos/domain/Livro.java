package com.gabriel.agendaobjetivos.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Livro {

	@JsonProperty
	private String nome;
	
	@JsonProperty
	private String tema;
	
}
