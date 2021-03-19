package com.example.demo.dto;

import javax.validation.constraints.NotBlank;

import com.example.demo.configuraton.validation.Unique;
import com.example.demo.entity.Pais;
import com.example.demo.repository.PaisRepository;

public class PaisDTO {
	
	private Long id;
	@NotBlank(message="insira um nome")
	@Unique(message="Pais já existente",table="paises",column="nome")
	private String nome;
	
	public void setNome(String nome) {
		this.nome = nome;
	}

	public Pais converter(PaisRepository repository) {
		return new Pais(nome);
	}
	
}
