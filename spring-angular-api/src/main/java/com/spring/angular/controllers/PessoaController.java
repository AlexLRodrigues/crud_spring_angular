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

import com.spring.angular.entidades.Documento;
import com.spring.angular.entidades.Pessoa;
import com.spring.angular.exceptions.ResourceNotFoundException;
import com.spring.angular.repositorios.PessoaRepository;

@RestController
public class PessoaController {

	@Autowired
	private PessoaRepository pessoaRepository;

	@GetMapping("/pessoas")
	public Page<Pessoa> getPessoa(Pageable pageable) {
		return pessoaRepository.findAll(pageable);
	}

	@PostMapping("/pessoas")
	public Pessoa createPessoa(@Valid @RequestBody Pessoa pessoa) {
		return pessoaRepository.save(pessoa);
	}

	@PutMapping("/pessoas/{pessoaId}")
	public Pessoa updatePost(@PathVariable Long pessoaId, @Valid @RequestBody Pessoa pessoaRequest) {
		return pessoaRepository.findById(pessoaId).map(pessoa -> {
			pessoa.setNomePessoa(pessoaRequest.getNomePessoa());
			pessoa.setEstado(pessoaRequest.getEstado());
			
			for (Documento doc : pessoaRequest.getListaDocumento()) {
				doc.setPessoa(pessoa);
			}
			
			pessoa.setListaDocumento(pessoaRequest.getListaDocumento());
			return pessoaRepository.save(pessoa);
		}).orElseThrow(() -> new ResourceNotFoundException("PessoaId " + pessoaId + " not found"));
	}

	@DeleteMapping("/pessoas/{pessoaId}")
	public ResponseEntity<?> deletePost(@PathVariable Long pessoaId) {
		return pessoaRepository.findById(pessoaId).map(pessoa -> {
			pessoaRepository.delete(pessoa);
			return ResponseEntity.ok().build();
		}).orElseThrow(() -> new ResourceNotFoundException("PessoaId " + pessoaId + " not found"));
	}
}
