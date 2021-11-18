package com.springboot.application.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.springboot.application.model.Dispositivo;
import com.springboot.application.repository.DispositivoRepository;
import com.springboot.application.service.DispositivoService;


public  class DispositivoServiceImpl implements DispositivoService{
	
	@Autowired
	private DispositivoRepository dispositivoRepository;
	
	@Autowired
	private DispositivoService dispositivoService;
	
	public DispositivoServiceImpl(DispositivoRepository dispositivoRepository) {
		super();
		this.dispositivoRepository = dispositivoRepository;
	}

	@Override
	public List<Dispositivo> buscarTodosDispositivos() {
		return dispositivoRepository.findAll();
	}

	@Override
	public Dispositivo salvarDispositivo(Dispositivo dispositivo)  {
	
		return dispositivoRepository.save(dispositivo);
	}

	@Override
	public Dispositivo pegarDispositivoPeloId(Long id) {
		return dispositivoRepository.findById(id).get();
	}

	@Override
	public Dispositivo atualizarDispositivo(Dispositivo dispositivo) {
		return dispositivoRepository.save(dispositivo);
	}

	@Override
	public void apagarDispositivoPeloId(Long id) {
		dispositivoRepository.deleteById(id);
		
	}

	@Override
	public List<Dispositivo> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Dispositivo> findAll(Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Dispositivo> findAllById(Iterable<Long> ids) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Dispositivo> List<S> saveAll(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void flush() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public <S extends Dispositivo> S saveAndFlush(S entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Dispositivo> List<S> saveAllAndFlush(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteAllInBatch(Iterable<Dispositivo> entities) {
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
	public Dispositivo getOne(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Dispositivo getById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Dispositivo> List<S> findAll(Example<S> example) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Dispositivo> List<S> findAll(Example<S> example, Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<Dispositivo> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Dispositivo> S save(S entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Dispositivo> findById(Long id) {
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
	public void delete(Dispositivo entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAllById(Iterable<? extends Long> ids) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll(Iterable<? extends Dispositivo> entities) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public <S extends Dispositivo> Optional<S> findOne(Example<S> example) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Dispositivo> Page<S> findAll(Example<S> example, Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Dispositivo> long count(Example<S> example) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public <S extends Dispositivo> boolean exists(Example<S> example) {
		// TODO Auto-generated method stub
		return false;
	}
	
	
	
	

}
