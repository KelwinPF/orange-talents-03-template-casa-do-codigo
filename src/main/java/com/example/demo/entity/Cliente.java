package com.example.demo.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="clientes")
public class Cliente implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 6482828447822341420L;
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id;
	@Column(nullable = false,unique=true)
	private String email;
	@Column(nullable = false)
	private String nome;
	@Column(nullable = false)
	private String sobrenome;
	@Column(nullable = false,unique=true)
	private String documento;
	@Column(nullable = false)
	private String endereco;
	@Column(nullable = false)
	private String complemento;
	@Column(nullable = false)
	private String cidade;
	@ManyToOne
	@JoinColumn(nullable = false)
	private Pais pais;
	@ManyToOne
	private Estado estado;
	@Column(nullable = false)
	private String telefone;
	@Column(nullable = false)
	private String cep;
	
	public Cliente(String email, String nome, String sobrenome, String documento, String endereco, String complemento,
			String cidade, Pais pais, Estado estado, String telefone, String cep) {
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
	
	public Cliente() {
		
	}

	public Long getId() {
		return id;
	}
	
	
}
