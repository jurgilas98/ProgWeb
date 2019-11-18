package com.gabriel.agendaobjetivos.controller;

import javax.persistence.Embeddable;

@Embeddable
public class Credenciais {

	private String login;
	private String senha;
	
	protected Credenciais() {}
	
	public Credenciais(String login, String senha) {
		this.login = login;
		this.senha = senha;
	}

	public String getSenha() {
		// TODO Auto-generated method stub
		return senha;
	}

	public String getLogin() {
		// TODO Auto-generated method stub
		return login;
	}


	
	
	
}
