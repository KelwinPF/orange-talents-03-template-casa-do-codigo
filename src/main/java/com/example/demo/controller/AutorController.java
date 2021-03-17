package com.example.demo.controller;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.AutorDTO;
import com.example.demo.repository.AutorRepository;

@RestController
@RequestMapping("/autores")
public class AutorController {
	
	private final AutorRepository repository;
	
	public AutorController(AutorRepository repository) {
		this.repository = repository;
	}
	
	@PostMapping
	@Transactional
	public ResponseEntity<AutorDTO> cadastrar(@Valid @RequestBody AutorDTO dto){
		repository.save(dto.converter(repository));
		return ResponseEntity.ok().build();
	}
}
