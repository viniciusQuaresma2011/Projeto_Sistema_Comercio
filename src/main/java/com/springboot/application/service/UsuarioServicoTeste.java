package com.springboot.application.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.application.model.Usuario;
import com.springboot.application.repository.UsuarioRepository;

@Service
public class UsuarioServicoTeste {
	
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	public void salvar(Usuario usuario) {
		usuarioRepository.save(usuario);
	}
	
	public boolean validar(Usuario usuario) {
		
		
		boolean disponibilidadeEmail = verificarDisponibilidadeEmail(usuario.getEmail());
		
		return disponibilidadeEmail ;
		
	}
	
	public boolean verificarDisponibilidadeEmail(String email) {
		return usuarioRepository.pesquisarEmail(email) == null;
	}
	
}