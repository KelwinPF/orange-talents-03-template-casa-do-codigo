package com.example.demo.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "paises")
public class Pais implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3342133973642630967L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	@Column(nullable = false,unique = true)
	private String nome;
	
	public Pais(String nome) {
		super();
		this.nome = nome;
	}
	
	public Pais() {
		
	}
	
	
}
