package com.example.demo.controller;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.PaisDTO;
import com.example.demo.repository.PaisRepository;

@RestController
@RequestMapping("/paises")
public class PaisController {
	
	private PaisRepository repository;
	
	public PaisController(PaisRepository repository) {
		this.repository = repository;
	}
	
	@PostMapping
	@Transactional
	public ResponseEntity<PaisDTO> cadastrar(@Valid @RequestBody PaisDTO dto){
		repository.save(dto.converter(repository));
		return ResponseEntity.ok().build();
	}
}
