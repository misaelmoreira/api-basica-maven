package com.br.estudos.Api.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.estudos.Api.modelView.Home;

@RestController
public class HomeController {

    @GetMapping("/")
    public Home index(){
        return new Home();
    }
}