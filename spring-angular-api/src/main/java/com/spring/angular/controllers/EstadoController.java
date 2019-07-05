package com.spring.angular.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.angular.entidades.Estado;
import com.spring.angular.services.EstadoService;

@RestController
public class EstadoController {
	
	@Autowired
	private EstadoService estadoService;
	
	@GetMapping("/estados")
	public List<Estado> buscarEstados() {
		return estadoService.buscarEstados();
	}

}
