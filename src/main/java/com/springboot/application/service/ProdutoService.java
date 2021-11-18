package com.springboot.application.service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.application.model.Produto;


public interface ProdutoService extends JpaRepository<Produto, Long> {
	
	List<Produto> buscarTodosOsProdutos();
	
	Produto salvarProduto(Produto produto);
	
	Produto pegarProdutoPeloId(Long id);
	
	Produto atualizarProduto(Produto produto);
	
	void apagarUsuarioPeloId(Long id);
}
