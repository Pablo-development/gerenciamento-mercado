package br.com.mercado.model;

import lombok.*;

@Setter
@Getter
@ToString
public class Produto {

    private String nome;
    private String descricao;
    private double preco;
    private String tipo;
    private int quantidade;

    public Produto(String nome, int quantidade){
        this.nome = nome;
        this.quantidade = quantidade;
    }
}
