package com.spring.angular.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.angular.entidades.Estado;
import com.spring.angular.repositorios.EstadoRepository;

@RestController
public class EstadoController {
	
	@Autowired
	private EstadoRepository estadoRepository;
	
	@GetMapping("/estados")
	public Page<Estado> getPessoa(Pageable pageable) {
		return estadoRepository.findAll(pageable);
	}

}
