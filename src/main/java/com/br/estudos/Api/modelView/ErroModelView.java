package com.br.estudos.Api.modelView;

public class ErroModelView {
    public ErroModelView(String mensagem){
        this.mensagem = mensagem;
    }

    private String mensagem;
    public String getMensagem(){
        return this.mensagem;
    }
    
}
