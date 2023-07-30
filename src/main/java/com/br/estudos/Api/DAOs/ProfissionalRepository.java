package com.br.estudos.Api.DAOs;

import org.springframework.data.jpa.repository.JpaRepository;

import com.br.estudos.Api.models.Profissional;

public interface ProfissionalRepository extends JpaRepository<Profissional, Integer>{
    
}
