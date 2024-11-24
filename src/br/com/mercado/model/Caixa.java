package br.com.mercado.model;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Caixa  {

    private String numeracaoCaixa;
    private double saldoCaixa;
    private FuncionarioCaixa operadorCaixa;
    private double compra = 0;
    private List<Produto> listaCompras = new ArrayList<>();

    public Caixa(String numeracaoCaixa, FuncionarioCaixa operadorCaixa){
        this.numeracaoCaixa = numeracaoCaixa;
        this.operadorCaixa = operadorCaixa;
    }


    public List<Produto> adicionaProdutosVenda(Produto produto){
        compra += produto.getPreco();
        listaCompras.add(produto);

        System.out.println("Valor da compra atual: " + compra);

        return listaCompras;
    }

    public String retiraValorCaixa(double valor){
        return ("Saldo atual em caixa: " + (saldoCaixa += valor));
    }

    public String adicionaValorCaixa(double valor){
        return ("Saldo atual em caixa: " + (saldoCaixa += valor));
    }

    //pode ser adicionado um metodo para fechamento de caixa, que, ao finalizar o dia, pode ser utilizado
    //salvando na db o ultimo saldo diario
}


