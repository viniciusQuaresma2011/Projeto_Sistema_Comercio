package com.springboot.application.service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.springboot.application.model.Dispositivo;



public interface DispositivoService extends JpaRepository<Dispositivo, Long> {
	
	List<Dispositivo> buscarTodosDispositivos();
	
	Dispositivo salvarDispositivo(Dispositivo dispositivo) ;
	
	Dispositivo pegarDispositivoPeloId(Long id);
	
	Dispositivo atualizarDispositivo(Dispositivo dispositivo);
	
	void apagarDispositivoPeloId(Long id);
}
