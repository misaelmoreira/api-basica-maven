package com.br.estudos.Api.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.estudos.Api.DTO.Home;
import com.br.estudos.Api.models.Profissional;
import com.br.estudos.Api.servicos.ProfissionalServico;

@RestController
public class HomeController {

    @GetMapping("/")
    public Home index(){
        return new Home();
    }

     @GetMapping("/profissionais")
    public List<Profissional> profissionais(){
        return ProfissionalServico.profissionais();
    }
}