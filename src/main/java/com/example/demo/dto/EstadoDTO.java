package com.example.demo.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.example.demo.configuraton.validation.Exists;
import com.example.demo.configuraton.validation.Unique;
import com.example.demo.entity.Estado;
import com.example.demo.repository.EstadoRepository;
import com.example.demo.repository.PaisRepository;


public class EstadoDTO {
	private Long id;
	@NotBlank(message="insira um nome")
	@Unique(message="estado já existente",table="estados",column="nome")
	private String nome;
	@NotNull(message="insira a pais")
	private Long pais;
	
	
	public EstadoDTO(@NotBlank(message = "insira um nome") String nome,
			@NotNull(message = "insira a pais") Long pais) {
		super();
		this.nome = nome;
		this.pais = pais;
	}


	public Estado converter(EstadoRepository repository,PaisRepository p_repository) {
		return new Estado(nome,p_repository.getOne(pais));
	}
}
