package com.gabriel.agendaobjetivos.domain;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.gabriel.agendaobjetivos.service.LivrariaService;

public class LivrariaTest {
	
	private LivrariaService livraria;
	
	@Before
	public void setUp() {
		livraria = new LivrariaService();
	}
	
	@Test
	public void listarOpinioes() {
		List<Opiniao> opinioes = livraria.lerTodasOpinioes();
		if(opinioes == null || opinioes.isEmpty()) {
			Assert.fail("Não tem nenhuma opinião cadastrada ainda. Ou a conexão com o microserviço não está funcionando");
		}
		else {
			for(Opiniao opiniao : opinioes) {
				String nome = opiniao.getNome();
				String texto = opiniao.getTexto();
				
				assertNotNull(nome);
				assertNotNull(texto);
			}
		}
	}
}
