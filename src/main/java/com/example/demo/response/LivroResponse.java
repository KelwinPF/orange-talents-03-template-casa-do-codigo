package com.example.demo.response;

import org.springframework.data.domain.Page;

import com.example.demo.entity.Livro;

public class LivroResponse{
	private Long id;
	private String titulo;
	
	public LivroResponse(Livro livro) {
		id = livro.getId();
		titulo = livro.getTitulo();
	}
	
	public Long getId() {
		return id;
	}
	public String getTitulo() {
		return titulo;
	}
	
	public static Page<LivroResponse> converter(Page<Livro> livros){
		return livros.map(LivroResponse::new);
	}

	
}
