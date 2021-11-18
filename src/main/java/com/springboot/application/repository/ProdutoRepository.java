package com.springboot.application.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.springboot.application.model.Produto;
import com.springboot.application.model.Usuario;


@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {
	
	
	//aqui consulta o nome do usuario 
		@Query(value = "select u from Produto u where u.nome like %?1% ")
		List<Produto> buscarPorNome(String nome);
		
		@Query(value ="select count(*) from Produto")
		int quantidadeDeObjetosProduto();
}
