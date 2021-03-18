package com.example.demo.dto;

import javax.validation.constraints.NotBlank;

import com.example.demo.configuraton.validation.Unique;
import com.example.demo.entity.Categoria;
import com.example.demo.repository.CategoriaRepository;

public class CategoriaDTO {
	private Long id;
	@Unique(message="nome já existente",table="categorias",column="nome")
	@NotBlank(message="insira um nome")
	private String nome;
	
	public void setNome(String nome) {
		this.nome = nome;
	}


	public Categoria converter(CategoriaRepository repository) {
		return new Categoria(nome);
	}
}
