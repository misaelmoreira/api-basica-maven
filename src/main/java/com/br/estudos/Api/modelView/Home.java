package com.br.estudos.Api.modelView;

public class Home {
    public String getMensagem(){
        return "Bem vindo a api feita no etudo sobre java";
    }

    public String getDocumentacao(){
        return "/swagger-ui.html";
    }

    public String getSwaggerJson(){
        return "/v2/api-docs";
    }
}