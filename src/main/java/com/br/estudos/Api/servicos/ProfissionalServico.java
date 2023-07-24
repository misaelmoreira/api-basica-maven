package com.br.estudos.Api.servicos;

import java.util.ArrayList;
import java.util.List;

import com.br.estudos.Api.models.Profissional;

public class ProfissionalServico {
    public static List<Profissional> profissionais(){
        var lista = new ArrayList<Profissional>(0);
        lista.add(new Profissional(1, "Walter"));
        lista.add(new Profissional(2, "Roberto"));
        lista.add(new Profissional(3, "Marcio"));

        return lista;     
    }
}
