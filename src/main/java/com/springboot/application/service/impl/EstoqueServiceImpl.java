package com.springboot.application.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.springboot.application.model.Estoque;
import com.springboot.application.repository.EstoqueRepository;
import com.springboot.application.service.EstoqueService;

@Service
public class EstoqueServiceImpl implements EstoqueService{
	
	private EstoqueRepository estoqueRepository;

	public EstoqueServiceImpl(EstoqueRepository estoqueRepository) {
		super();
		this.estoqueRepository = estoqueRepository;
	}

	

	@Override
	public List<Estoque> buscarTodosOsEstoques() {
		return estoqueRepository.findAll();
	}

	@Override
	public Estoque salvarEstoque(Estoque estoque) {
		return estoqueRepository.save(estoque);
	}

	@Override
	public Estoque pegarEstoquePeloId(Long id) {
		return estoqueRepository.findById(id).get();
	}

	@Override
	public Estoque atualizarEstoque(Estoque estoque) {
		return estoqueRepository.save(estoque);
	}

	@Override
	public void apagarEstoquePeloId(Long id) {
		estoqueRepository.deleteById(id);
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@Override
	public List<Estoque> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Estoque> findAll(Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Estoque> findAllById(Iterable<Long> ids) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Estoque> List<S> saveAll(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void flush() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public <S extends Estoque> S saveAndFlush(S entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Estoque> List<S> saveAllAndFlush(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteAllInBatch(Iterable<Estoque> entities) {
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
	public Estoque getOne(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Estoque getById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Estoque> List<S> findAll(Example<S> example) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Estoque> List<S> findAll(Example<S> example, Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<Estoque> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Estoque> S save(S entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Estoque> findById(Long id) {
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
	public void delete(Estoque entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAllById(Iterable<? extends Long> ids) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll(Iterable<? extends Estoque> entities) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public <S extends Estoque> Optional<S> findOne(Example<S> example) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Estoque> Page<S> findAll(Example<S> example, Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Estoque> long count(Example<S> example) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public <S extends Estoque> boolean exists(Example<S> example) {
		// TODO Auto-generated method stub
		return false;
	}
	
	
}
