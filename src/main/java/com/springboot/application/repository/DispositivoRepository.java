package com.springboot.application.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.springboot.application.model.Dispositivo;
import com.springboot.application.model.Produto;

@Repository
public interface DispositivoRepository extends JpaRepository<Dispositivo, Long> {
	
	@Query(value = "select u from Dispositivo u where u.nome like %?1% ")
	List<Dispositivo> buscarPorNome(String nome);
	
	@Query(value ="select count(*) from Dispositivo")
	int quantidadeDeObjetosDispositivo();
}
