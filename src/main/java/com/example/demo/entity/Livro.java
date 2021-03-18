package com.example.demo.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "livros")
public class Livro implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7495791241455789041L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	@Column(nullable = false,unique = true)
	private String titulo;
	@Column(nullable = false,length = 500)
	private String resumo;
	@Column(columnDefinition = "TEXT", nullable = false)
	private String sumario;
	@Column(nullable = false)
	private Integer numero_paginas;
	@Column(unique = true, nullable = false)
	private String isbn;
	@Column(nullable = false)
	private LocalDate data;
	@Column(nullable = false,scale = 2)
	private BigDecimal valor;
	@ManyToOne
	@JoinColumn(nullable = false)
	private Categoria categoria;
	@ManyToOne
	@JoinColumn(nullable = false)
	private Autor autor;
	
	public Livro(String titulo, String resumo, String sumario, Integer numero_paginas, String isbn, LocalDate data,
			BigDecimal valor, Categoria categoria, Autor autor) {
		super();
		this.titulo = titulo;
		this.resumo = resumo;
		this.sumario = sumario;
		this.numero_paginas = numero_paginas;
		this.isbn = isbn;
		this.data = data;
		this.valor = valor;
		this.categoria = categoria;
		this.autor = autor;
	}
	
	public Livro() {
		
	}
	
}
