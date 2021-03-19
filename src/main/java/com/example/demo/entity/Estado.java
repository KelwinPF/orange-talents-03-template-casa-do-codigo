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
@Table(name = "estados")
public class Estado implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5503876445035276803L;
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	@Column(nullable = false,unique=true)
	private String nome;
	@ManyToOne
	@JoinColumn(nullable = false,name="pais_id")
	private Pais pais;
	
	public Estado(String nome, Pais pais) {
		super();
		this.nome = nome;
		this.pais = pais;
	}
	
	public Estado() {
		
	}
	
	
}
