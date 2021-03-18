package com.example.demo.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.example.demo.configuraton.validation.Exists;
import com.example.demo.configuraton.validation.Unique;
import com.example.demo.entity.Autor;
import com.example.demo.entity.Categoria;
import com.example.demo.entity.Livro;
import com.example.demo.repository.AutorRepository;
import com.example.demo.repository.CategoriaRepository;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

public class LivroDTO {
	private Long id;
	@NotBlank(message="insira um título")
	@Unique(message="título já existente",table="livros",column="titulo")
	private String titulo;
	@NotBlank(message="insira um resumo")
	@Size(max=500)
	private String resumo;
	@NotBlank(message="insira um resumo")
	private String sumario;
	@Min(value = 100)
	private Integer numero_paginas;
	@NotNull
	@Min(value=20)
	private BigDecimal preco;
	@NotBlank(message="insira um título")
	@Unique(message="isbn já existente",table="livros",column="isbn")
	private String isbn;
	@Future
	@JsonFormat(pattern="dd/MM/yyyy",shape = Shape.STRING)
	private LocalDate data;
	@NotNull(message="insira a categoria")
	@Exists(table = "categorias")
	private Long categoria;
	@NotNull(message="insira a categoria")
	@Exists(table = "autores")
	private Long autor;
	
	public LivroDTO(@NotBlank(message = "insira um título") String titulo,
			@NotBlank(message = "insira um resumo") @Size(max = 500) String resumo,
			@NotBlank(message = "insira um resumo") String sumario, @Min(100) Integer numero_paginas,
			@NotNull @Min(20) BigDecimal preco, @NotBlank(message = "insira um título") String isbn,
			@NotNull(message = "insira a categoria") Long categoria,
			@NotNull(message = "insira a categoria") Long autor) {
		super();
		this.titulo = titulo;
		this.resumo = resumo;
		this.sumario = sumario;
		this.numero_paginas = numero_paginas;
		this.preco = preco;
		this.isbn = isbn;
		this.categoria = categoria;
		this.autor = autor;
	}
	
	public void setData(LocalDate data) {
		this.data = data;
	}
	
	public Livro converter(AutorRepository a_repository,CategoriaRepository c_repository) {
		Categoria cat = c_repository.getOne(categoria);
		Autor autor = a_repository.getOne(categoria);
		return new Livro(titulo,resumo,sumario,numero_paginas,isbn,data,preco,cat,autor);
	}
	
	
}
