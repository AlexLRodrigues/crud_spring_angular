package com.spring.angular.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
@Table(name = "estado")
public class Estado {

	@Id
	@Column(name = "idEstado")
	@GeneratedValue
	private Long idEstado;

	@Column(name = "nomeEstado")
	private String nomeEstado;

	@JsonBackReference
	@OneToOne(mappedBy = "estado")
	private Pessoa pessoa;

	public Estado() {
		super();
	}

	public Estado(Long idEstado, String nomeEstado) {
		super();
		this.idEstado = idEstado;
		this.nomeEstado = nomeEstado;
	}
	
	public Estado(Long idEstado, String nomeEstado, Pessoa pessoa) {
		super();
		this.idEstado = idEstado;
		this.nomeEstado = nomeEstado;
		this.pessoa = pessoa;
	}

	public Long getIdEstado() {
		return idEstado;
	}

	public void setIdEstado(Long idEstado) {
		this.idEstado = idEstado;
	}

	public String getNomeEstado() {
		return nomeEstado;
	}

	public void setNomeEstado(String nomeEstado) {
		this.nomeEstado = nomeEstado;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

}
