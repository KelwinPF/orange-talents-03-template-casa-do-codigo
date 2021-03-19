package com.example.demo.response;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import com.example.demo.entity.Livro;

public class LivroDetalheResponse {
	private String titulo;
	private String resumo;
	private String sumario;
	private BigDecimal valor;
	private String isbn;
	private Integer numero_paginas;
	private String nome_autor;
	private String descricao_autor;
	private String data_publicacao;
	
	public LivroDetalheResponse(Livro livro) {
		
		this.titulo = livro.getTitulo();
		this.resumo = livro.getResumo();
		this.sumario = livro.getSumario();
		this.valor = livro.getValor();
		this.isbn = livro.getIsbn();
		this.numero_paginas = livro.getNumero_paginas();
		this.nome_autor = livro.getAutor().getNome();
		this.descricao_autor = livro.getAutor().getDescricao();
		this.data_publicacao = livro.getData().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
	}
	
	public String getData_publicacao() {
		return data_publicacao;
	}
	
	public String getTitulo() {
		return titulo;
	}

	public String getResumo() {
		return resumo;
	}

	public String getSumario() {
		return sumario;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public String getIsbn() {
		return isbn;
	}

	public Integer getNumero_paginas() {
		return numero_paginas;
	}

	public String getNome_autor() {
		return nome_autor;
	}

	public String getDescricao_autor() {
		return descricao_autor;
	}
	
	
}
