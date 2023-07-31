package com.br.estudos.Api.DAOs;

import org.springframework.data.repository.CrudRepository;

import com.br.estudos.Api.models.Profissional;

public interface IProfissionalRepository extends CrudRepository<Profissional, Integer>{
    
}
