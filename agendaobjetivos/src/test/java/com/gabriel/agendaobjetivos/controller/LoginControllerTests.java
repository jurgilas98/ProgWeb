package com.gabriel.agendaobjetivos.controller;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.gabriel.agendaobjetivos.domain.TodosUsuarios;
import com.gabriel.agendaobjetivos.domain.Usuario;

public class LoginControllerTests {
	
	private LoginController controller;
	private TodosUsuarios todosUsuarios;
	
	@Before
	public void setup() {
		todosUsuarios = Mockito.mock(TodosUsuarios.class);
		controller = new LoginController(todosUsuarios);
	}
	
	@Test
	public void loginSucesso() {
		Credenciais c = new Credenciais("igual","igual");
		Mockito.when(todosUsuarios.existe(c)).thenReturn(new Usuario("nome",40));
		ResponseEntity<String> resposta = controller.validarLogin(c);
		
		assertEquals(HttpStatus.OK,resposta.getStatusCode());
		assertEquals("Sucesso!", resposta.getBody());
	}
	
	@Test
	public void loginFalha() {
		Credenciais c = new Credenciais();
		Mockito.when(todosUsuarios.existe(c)).thenReturn(null);
		ResponseEntity<String> resposta = controller.validarLogin(new Credenciais("login","senha"));
		assertEquals(HttpStatus.UNAUTHORIZED,resposta.getStatusCode());
		assertEquals("Erro", resposta.getBody());
		
	}
}
