package com.example.demo.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.example.demo.configuraton.validation.Unique;
import com.example.demo.entity.Autor;
import com.example.demo.repository.AutorRepository;

public class AutorDTO {
	private Long id;
	@Email(message="insira um email válido")
	@NotBlank(message="insira um email")
	@Unique(message="email já existente",table="autores",column="email")
	private String email;
	@NotBlank(message="insira um nome")
	private String nome;
	@NotBlank(message="insira uma descrição")
	@Size(max=400,message="Descrição deve conter menos de 400 caracteres")
	private String descricao;
	
	public AutorDTO(String email,String nome,String descricao){
		this.email = email;
		this.descricao = descricao;
		this.nome = nome;
	}
	
	public Autor converter(AutorRepository repository) {
		return new Autor(email, nome, descricao);
	}
}
