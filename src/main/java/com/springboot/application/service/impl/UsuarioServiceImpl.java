package com.springboot.application.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.springboot.application.model.Usuario;
import com.springboot.application.repository.UsuarioRepository;
import com.springboot.application.service.UsuarioService;

@Service
public class UsuarioServiceImpl  implements UsuarioService{
	
	
	private UsuarioRepository usuarioRepository;
	
	private UsuarioService usuarioService;
	
	public UsuarioServiceImpl(UsuarioRepository usuarioRepository) {
		super();
		this.usuarioRepository = usuarioRepository;
	}
	

	@Override
	public List<Usuario> buscarTodosUsuarios() {
		
		return usuarioRepository.findAll();
	}

	@Override
	public Usuario salvarUsuario(Usuario usuario) {
		return usuarioRepository.save(usuario);
	}

	@Override
	public Usuario pegarUsuarioPeloId(Long id) {
		return usuarioRepository.findById(id).get();
	}

	@Override
	public Usuario atualizarUsuario(Usuario usuario) {
		return usuarioRepository.save(usuario);
	}

	@Override
	public void apagarUsuarioPeloId(Long id) {
		usuarioRepository.deleteById(id);
		
	}
	
	
	

	
	
	
	
	
	
	

	@Override
	public List<Usuario> findAll() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<Usuario> findAll(Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<Usuario> findAllById(Iterable<Long> ids) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public <S extends Usuario> List<S> saveAll(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void flush() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public <S extends Usuario> S saveAndFlush(S entity) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public <S extends Usuario> List<S> saveAllAndFlush(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void deleteAllInBatch(Iterable<Usuario> entities) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void deleteAllByIdInBatch(Iterable<Long> ids) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void deleteAllInBatch() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public Usuario getOne(Long id) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Usuario getById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public <S extends Usuario> List<S> findAll(Example<S> example) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public <S extends Usuario> List<S> findAll(Example<S> example, Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Page<Usuario> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public <S extends Usuario> S save(S entity) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Optional<Usuario> findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public boolean existsById(Long id) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void delete(Usuario entity) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void deleteAllById(Iterable<? extends Long> ids) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void deleteAll(Iterable<? extends Usuario> entities) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public <S extends Usuario> Optional<S> findOne(Example<S> example) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public <S extends Usuario> Page<S> findAll(Example<S> example, Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public <S extends Usuario> long count(Example<S> example) {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public <S extends Usuario> boolean exists(Example<S> example) {
		// TODO Auto-generated method stub
		return false;
	}

	

}
