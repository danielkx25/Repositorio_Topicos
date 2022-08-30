package com.Topicos.RelogioPonto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Topicos.RelogioPonto.model.Registro;

@Repository
public interface RegistroRepository extends JpaRepository<Registro, Long>{

}
