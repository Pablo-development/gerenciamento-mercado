package br.com.mercado.model;

import lombok.*;

@Getter
@Setter
@ToString
public class FuncionarioCaixa extends Colaborador {
    public FuncionarioCaixa(String name){
        this.name = name;
    }
}
