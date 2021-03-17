package com.example.demo.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "autores")
public class Autor implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7370988178359214613L;
	
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String email;
    @Column(nullable = false)
    private String nome;
    @Column(nullable = false,length=400)
    private String descricao;
    
	public Autor(String email, String nome, String descricao) {
		this.email = email;
		this.nome = nome;
		this.descricao = descricao;
	}
	
    
}
