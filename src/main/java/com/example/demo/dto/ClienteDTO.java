package com.example.demo.dto;

import javax.validation.constraints.Email;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.example.demo.configuraton.validation.Exists;
import com.example.demo.configuraton.validation.IsCountryState;
import com.example.demo.configuraton.validation.Unique;
import com.example.demo.configuraton.validation.VerifyDocument;
import com.example.demo.entity.Cliente;
import com.example.demo.entity.Estado;
import com.example.demo.entity.Pais;
import com.example.demo.repository.EstadoRepository;
import com.example.demo.repository.PaisRepository;

@IsCountryState
public class ClienteDTO {
	
	@NotBlank(message="insira um email")
	@Unique(message="email já existente",table="clientes",column="email")
	@Email(message="insira um email válido")
	private String email;
	@NotBlank(message="insira um nome")
	private String nome;
	@NotBlank(message="insira um sobrenome")
	private String sobrenome;
	@VerifyDocument(message="cpf ou cnpj invalido")
	@Unique(message="cpf/cnpj já existente",table="clientes",column="documento")
	@NotBlank(message="insira um documento")
	private String documento;
	@NotBlank(message="insira um endereco")
	private String endereco;
	@NotBlank(message="insira um complemento")
	private String complemento;
	@NotBlank(message="insira um cidade")
	private String cidade;
	@NotNull(message="insira um pais")
	@Exists(table = "paises")
	private Long pais;
	private Long estado;
	@NotBlank(message="insira um telefone")
	private String telefone;
	@NotBlank(message="insira um cep")
	private String cep;
	
	public ClienteDTO(@NotBlank(message = "insira um email") @Email(message = "insira um email válido") String email,
			@NotBlank(message = "insira um nome") String nome,
			@NotBlank(message = "insira um sobrenome") String sobrenome,
			@NotBlank(message = "insira um documento") String documento,
			@NotBlank(message = "insira um endereco") String endereco,
			@NotBlank(message = "insira um complemento") String complemento,
			@NotBlank(message = "insira um cidade") String cidade, @NotNull(message = "insira um pais") Long pais,
			Long estado, @NotBlank(message = "insira um telefone") String telefone,
			@NotBlank(message = "insira um cep") String cep) {
		super();
		this.email = email;
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.documento = documento;
		this.endereco = endereco;
		this.complemento = complemento;
		this.cidade = cidade;
		this.pais = pais;	
		this.estado = estado;
		this.telefone = telefone;
		this.cep = cep;
	}

	public Long getPais() {
		return pais;
	}

	public Long getEstado() {
		return estado;
	}

	public Cliente converter(EstadoRepository e_repository,PaisRepository p_repository) {
		
		Pais country = p_repository.getOne(pais);
		Estado state = null;
		
		if(this.getEstado() != null) {
			state = e_repository.getOne(estado);
		}
		
		return new Cliente(
				email,nome,sobrenome,documento,endereco,
				complemento,cidade,country,
				state,telefone,cep);
	}
	
	
}
