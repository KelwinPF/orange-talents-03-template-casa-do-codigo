package com.example.demo.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="categorias")
public class Categoria implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -141100450138424861L;
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id;
    @Column(nullable = false,unique=true)
    private String nome;
    
    public Categoria(String nome) {
    	this.nome = nome;
    }
}
