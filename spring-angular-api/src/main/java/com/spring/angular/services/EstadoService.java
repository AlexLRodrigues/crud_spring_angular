package com.spring.angular.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.spring.angular.entidades.Estado;
import com.spring.angular.repositorios.EstadoRepository;

@Service
public class EstadoService {
	
	@Autowired
	private EstadoRepository estadoRepository;
	
	public Page<Estado> buscarEstados(Pageable pageable) {
		return estadoRepository.findAll(pageable);
	}

}
