package br.com.mercado.model;

import lombok.*;

@Getter
@Setter
@ToString
public class FuncionarioCaixa extends Colaborador {
    public FuncionarioCaixa(String name, String cpf, double salario, String turno){
        this.name = name;
        this.cpf = cpf;
        this.salario = salario;
        this.turno = turno;
    }
}
