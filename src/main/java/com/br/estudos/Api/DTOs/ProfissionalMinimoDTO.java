package com.br.estudos.Api.DTOs;

import com.br.estudos.Api.interfaces.IObjectDTO;

public class ProfissionalMinimoDTO implements IObjectDTO{
    private String nome;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }    
}
