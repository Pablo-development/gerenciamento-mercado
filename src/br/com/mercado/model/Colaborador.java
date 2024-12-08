package br.com.mercado.model;

import lombok.*;

@Setter
@Getter
@ToString
public abstract class Colaborador {
    protected String name;
    protected int age;
    protected String phoneNumber;
    protected String cpf;
    protected double salario;
    protected String turno;
}
