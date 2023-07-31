package com.br.estudos.Api.servicos;

import java.util.ArrayList;
import java.util.List;

import com.br.estudos.Api.DTOs.ProfissionalDTO;
import com.br.estudos.Api.models.Profissional;

public class ProfissionalServico {

    private ProfissionalServico() {}

    private List<Profissional> profissionais;
    private static ProfissionalServico profissionalServico;

    public static Profissional builderDTOModel(ProfissionalDTO profissionalDTO){
        return builderDTOModel(profissionalDTO, null);
    }

    public static Profissional builderDTOModel(ProfissionalDTO profissionalDTO, Profissional profissional){
        if(profissional != null) profissional = new Profissional();

        profissional.setNome(profissionalDTO.getNome());
        profissional.setObservacao(profissionalDTO.getObservacao());
             
        return profissional;
    }

    public static ProfissionalServico getInstancia(){
        if(profissionalServico == null){
            profissionalServico = new ProfissionalServico();
        }
        return profissionalServico;     
    }

    public List<Profissional> getProfissionais(){
        if(this.profissionais == null){
            this.profissionais = new ArrayList<Profissional>();
        }
        return this.profissionais;     
    }


    public void adicionar(Profissional profissional){
        this.profissionais.add(profissional);
    }

    public Profissional buscaPorId(int id) {
        for( Profissional profFor : this.profissionais){
            if(profFor.getId() == id){
                return profFor;
            }
        }
        return null;
    } 
}
