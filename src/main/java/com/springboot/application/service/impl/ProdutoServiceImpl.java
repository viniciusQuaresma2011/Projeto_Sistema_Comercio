package com.springboot.application.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.springboot.application.model.Produto;
import com.springboot.application.repository.ProdutoRepository;
import com.springboot.application.service.ProdutoService;


@Service
public class ProdutoServiceImpl implements ProdutoService {
	
	
	private ProdutoRepository produtoRepository;
	
	
	
	
	public ProdutoServiceImpl(ProdutoRepository produtoRepository) {
		super();
		this.produtoRepository = produtoRepository;
	}

	@Override
	public List<Produto> buscarTodosOsProdutos() {
		
		return produtoRepository.findAll();
	}

	@Override
	public Produto salvarProduto(Produto produto) {
		
		return produtoRepository.save(produto);
	}

	@Override
	public Produto pegarProdutoPeloId(Long id) {
		
		return produtoRepository.findById(id).get();
	}
	
	@Override
	public Produto atualizarProduto(Produto produto) {
		return produtoRepository.save(produto);
	}
	
	@Override
	public void apagarUsuarioPeloId(Long id) {
		produtoRepository.deleteById(id);
		
	}
	
	
	
	
	
	
	
	
	
	

	@Override
	public List<Produto> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Produto> findAll(Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Produto> findAllById(Iterable<Long> ids) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Produto> List<S> saveAll(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void flush() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public <S extends Produto> S saveAndFlush(S entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Produto> List<S> saveAllAndFlush(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteAllInBatch(Iterable<Produto> entities) {
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
	public Produto getOne(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Produto getById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Produto> List<S> findAll(Example<S> example) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Produto> List<S> findAll(Example<S> example, Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<Produto> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Produto> S save(S entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Produto> findById(Long id) {
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
	public void delete(Produto entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAllById(Iterable<? extends Long> ids) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll(Iterable<? extends Produto> entities) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public <S extends Produto> Optional<S> findOne(Example<S> example) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Produto> Page<S> findAll(Example<S> example, Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Produto> long count(Example<S> example) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public <S extends Produto> boolean exists(Example<S> example) {
		// TODO Auto-generated method stub
		return false;
	}
	
}
