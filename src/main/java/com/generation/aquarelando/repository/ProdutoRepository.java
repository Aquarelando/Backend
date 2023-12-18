package com.generation.aquarelando.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.generation.aquarelando.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto,Long> {
			
	
}
