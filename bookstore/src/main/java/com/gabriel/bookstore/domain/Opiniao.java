package com.gabriel.bookstore.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Opiniao {

	@JsonProperty
	private String nome;
	
	@JsonProperty
	private String texto;

	public String getNome() {
		return nome;
	}

	public String getTexto() {
		return texto;
	}
	
}
