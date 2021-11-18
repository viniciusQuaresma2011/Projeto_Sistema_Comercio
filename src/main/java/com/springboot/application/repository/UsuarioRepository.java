package com.springboot.application.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.springboot.application.model.Usuario;


@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
	
	
	//aqui consulta o nome do usuario 
	@Query(value = "select u from Usuario u where u.nome like %?1% ")
	List<Usuario> buscarPorNome(String nome);
	
	@Query(value ="select count(*) from Usuario")
	int quantidadeDeObjetos();
	
	@Query("SELECT p FROM Usuario p WHERE p.email =:email")
	Usuario pesquisarEmail(@Param("email") String email);
	
	
	
}
