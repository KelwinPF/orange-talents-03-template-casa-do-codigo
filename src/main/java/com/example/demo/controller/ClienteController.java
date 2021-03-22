package com.example.demo.controller;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.ClienteDTO;
import com.example.demo.entity.Cliente;
import com.example.demo.repository.ClienteRepository;
import com.example.demo.repository.EstadoRepository;
import com.example.demo.repository.PaisRepository;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
	
	private ClienteRepository repository;
	private EstadoRepository e_repository;
	private PaisRepository p_repository;
	
	public ClienteController(ClienteRepository repository,EstadoRepository e_repository,PaisRepository p_repository) {
		this.repository = repository;
		this.e_repository = e_repository;
		this.p_repository = p_repository;
	}
	
	@PostMapping
	@Transactional
	public ResponseEntity<Long> cadastrar(@Valid @RequestBody ClienteDTO dto){
		Cliente c = repository.save(dto.converter(e_repository,p_repository));
		return ResponseEntity.ok().body(c.getId());
	}
	
}
