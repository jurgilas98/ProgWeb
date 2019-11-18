package com.gabriel.agendaobjetivos.domain;

import java.util.List;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.gabriel.agendaobjetivos.controller.Credenciais;

@Entity
@Table(name="usuarios")
public class Usuario {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@Embedded
	@JsonProperty
	private Credenciais credenciais;
	private String nome;
	private int idade;

	@OneToMany(mappedBy="usuario")
	private List<Objetivo> objetivos;
	
	public String getNome() {
		return nome;
	}

	public int getIdade() {
		return idade;
	}
	
	public Usuario() {}

	public Usuario(String nome, int idade) {
		this.nome = nome;
		this.idade = idade;
	}
	
	
}
