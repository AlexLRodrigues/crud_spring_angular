package com.spring.angular.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.angular.entidades.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {

}
