package com.example.demo.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.entity.Livro;

public interface LivroRepository extends JpaRepository<Livro,Long>{
	Page<Livro> findAll(Pageable page);
	
}
