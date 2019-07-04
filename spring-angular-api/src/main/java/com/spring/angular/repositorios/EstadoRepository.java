package com.spring.angular.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.angular.entidades.Estado;

public interface EstadoRepository extends JpaRepository<Estado, Long> {

}
