package com.spring.angular.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.angular.entidades.Pessoa;
import com.spring.angular.services.PessoaService;

@RestController
public class PessoaController {

	@Autowired
	private PessoaService pessoaService;

	@GetMapping("/pessoas")
	public Page<Pessoa> getPessoa(Pageable pageable) {
		return pessoaService.buscarPessoas(pageable);
	}

	@PostMapping("/pessoas")
	public Pessoa createPessoa(@Valid @RequestBody Pessoa pessoa) {
		return pessoaService.criarPessoa(pessoa);
	}

	@PutMapping("/pessoas/{pessoaId}")
	public Pessoa updatePost(@PathVariable Long pessoaId, @Valid @RequestBody Pessoa pessoaRequest) {
		return pessoaService.atualizarPessoa(pessoaId, pessoaRequest);
	}

	@DeleteMapping("/pessoas/{pessoaId}")
	public ResponseEntity<?> deletePost(@PathVariable Long pessoaId) {
		return pessoaService.removerPessoa(pessoaId);
	}
}
