package com.gabriel.agendaobjetivos.domain;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity 
@Table(name="objetivos")
public class Objetivo {

	@Id
	@GeneratedValue
	private Long id;
	
	@JsonProperty
	private String titulo;
	
	@Embedded
	@JsonProperty
	private Prioridade prioridade;
	
	@ManyToOne
	@JoinColumn(name="usuario_id")
	private Usuario usuario;
	
	@JsonProperty
	private String descricao;
	
	@Column(name = "data_maxima_para_o_sucesso")
	@JsonProperty
	private LocalDate dataMaximaParaExecucao;
	
	
	
	public Objetivo() {}
	
	

	public Objetivo(Long id, String titulo, Prioridade prioridade, String descricao, LocalDate dataMaximaParaExecucao) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.prioridade = prioridade;
		this.descricao = descricao;
		this.dataMaximaParaExecucao = dataMaximaParaExecucao;
	}



	@Override
	public String toString() {
		return "Objetivo [id=" + id + ", titulo=" + titulo + ", prioridade=" + prioridade + ", descricao=" + descricao
				+ ", dataMaximaParaExecucao=" + dataMaximaParaExecucao + "]";
	}



	public boolean ate(LocalDate data) {
		return dataMaximaParaExecucao.isBefore(data) || dataMaximaParaExecucao.isEqual(data);
	}

	/*
	public String getTitulo() {
		return titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public LocalDate getDataMaximaParaExecucao() {
		return dataMaximaParaExecucao;
	}*/
}
