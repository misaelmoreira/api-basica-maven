package com.br.estudos.Api.DTOs;

import com.br.estudos.Api.interfaces.IObjectDTO;

public class ProfissionalDTO implements IObjectDTO{
    private String nome;
    private String Observacao;

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getObservacao() {
        return Observacao;
    }
    public void setObservacao(String observacao) {
        Observacao = observacao;
    }
    
}
