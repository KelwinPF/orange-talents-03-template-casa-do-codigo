package com.example.demo.controller;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.EstadoDTO;
import com.example.demo.repository.EstadoRepository;
import com.example.demo.repository.PaisRepository;

@RestController
@RequestMapping("/estados")
public class EstadoController {
	
	private EstadoRepository repository;
	private PaisRepository p_repository;
	
	public EstadoController(EstadoRepository repository,PaisRepository p_repository) {
		this.repository = repository;
		this.p_repository = p_repository;
	}
	

	@PostMapping
	@Transactional
	public ResponseEntity<EstadoDTO> cadastrar(@Valid @RequestBody EstadoDTO dto){
		repository.save(dto.converter(repository,p_repository));
		return ResponseEntity.ok().build();
	}
}
