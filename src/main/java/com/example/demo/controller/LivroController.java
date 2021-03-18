package com.example.demo.controller;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.LivroDTO;
import com.example.demo.repository.AutorRepository;
import com.example.demo.repository.CategoriaRepository;
import com.example.demo.repository.LivroRepository;

@RestController
@RequestMapping("/livros")
public class LivroController {
	
	private LivroRepository repository;
	private CategoriaRepository c_repository;
	private AutorRepository a_repository;
	
	public LivroController(LivroRepository repository,CategoriaRepository c_repository,
			AutorRepository a_repository) {
		this.repository = repository;
		this.c_repository = c_repository;
		this.a_repository = a_repository;
	}
	
	@PostMapping
	@Transactional
	public ResponseEntity<LivroDTO> cadastrar(@Valid @RequestBody LivroDTO dto){
		repository.save(dto.converter(a_repository,c_repository));	
		return ResponseEntity.ok().build();
	}
}