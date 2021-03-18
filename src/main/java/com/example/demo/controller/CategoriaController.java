package com.example.demo.controller;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.CategoriaDTO;
import com.example.demo.repository.CategoriaRepository;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {
	
	private CategoriaRepository repository;
	
	public CategoriaController(CategoriaRepository repository) {
		this.repository = repository;
	}
	
	@PostMapping
	@Transactional
	public ResponseEntity<CategoriaDTO> cadastrar(@Valid @RequestBody CategoriaDTO dto){
		repository.save(dto.converter(repository));
		return ResponseEntity.ok().build();
	}
}
