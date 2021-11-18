package com.springboot.application.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.application.model.Usuario;

@Service
public class ServicoGeral {
	
	@Autowired
	private UsuarioServicoTeste usuarioServicoTeste;
	
	public boolean salvar(Usuario usuario) throws Exception {
		if(!usuarioServicoTeste.validar(usuario)) {
			throw new Exception("Usuario nao existe");
		}
		
		usuarioServicoTeste.salvar(usuario);
		
		return true;
	}
}