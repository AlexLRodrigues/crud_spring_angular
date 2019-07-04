package com.spring.angular.services;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.spring.angular.entidades.Documento;
import com.spring.angular.entidades.Pessoa;
import com.spring.angular.exceptions.ResourceNotFoundException;
import com.spring.angular.repositorios.PessoaRepository;

@Service
public class PessoaService {

	@Autowired
	private PessoaRepository pessoaRepository;
	
	public Page<Pessoa> buscarPessoas(Pageable pageable) {
		return pessoaRepository.findAll(pageable);
	}

	public Pessoa criarPessoa(@Valid @RequestBody Pessoa pessoa) {
		return pessoaRepository.save(pessoa);
	}

	public Pessoa atualizarPessoa(Long pessoaId, Pessoa pessoaRequest) {
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

	public ResponseEntity<?> removerPessoa(Long pessoaId) {
		return pessoaRepository.findById(pessoaId).map(pessoa -> {
			pessoaRepository.delete(pessoa);
			return ResponseEntity.ok().build();
		}).orElseThrow(() -> new ResourceNotFoundException("PessoaId " + pessoaId + " not found"));
	}
}
