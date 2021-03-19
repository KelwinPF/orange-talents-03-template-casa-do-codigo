package com.example.demo.controller;

import java.util.List;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.LivroDTO;
import com.example.demo.repository.AutorRepository;
import com.example.demo.repository.CategoriaRepository;
import com.example.demo.repository.LivroRepository;
import com.example.demo.response.LivroResponse;


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
	
	@GetMapping
	public Page<LivroResponse> lista(
			@PageableDefault(sort="id",direction = Direction.ASC,page =0,size=10) Pageable pag){
		return LivroResponse.converter(repository.findAll(pag));
	}
}