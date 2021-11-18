package com.springboot.application.service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.application.model.Estoque;

public interface EstoqueService extends JpaRepository<Estoque, Long>{
	
	List<Estoque> buscarTodosOsEstoques();
	
	Estoque salvarEstoque(Estoque estoque);
	
	Estoque pegarEstoquePeloId(Long id);
	
	Estoque atualizarEstoque(Estoque estoque);
	
	void apagarEstoquePeloId(Long id);
	
	
}
