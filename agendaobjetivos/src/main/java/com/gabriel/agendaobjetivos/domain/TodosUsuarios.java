package com.gabriel.agendaobjetivos.domain;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.gabriel.agendaobjetivos.controller.Credenciais;

@Repository
public interface TodosUsuarios extends JpaRepository<Usuario, Long> {
	
	@Query("select u from Usuario u where u.credenciais = :credenciais")
	public Usuario existe(@Param("credenciais")Credenciais credendiais);

	public List<Usuario> findByNomeAndIdade(String nome, Integer idade);
	
	//@Query("from Usuario where nome = :nome")
	public List<Usuario> findByNome(String nome);

	@Query("from Usuario where idade = :idade")
	public List<Usuario> porIdade(@Param("idade") Integer idade);
}
