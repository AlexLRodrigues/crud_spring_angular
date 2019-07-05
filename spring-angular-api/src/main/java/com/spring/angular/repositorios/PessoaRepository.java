package com.spring.angular.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.spring.angular.entidades.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
    @Query(value = "SELECT p FROM Pessoa p LEFT JOIN FETCH p.estado LEFT JOIN FETCH p.listaDocumento where p.idPessoa = :idPessoa")   
    Pessoa buscarPorID(@Param("idPessoa") Long idPessoa);
}
