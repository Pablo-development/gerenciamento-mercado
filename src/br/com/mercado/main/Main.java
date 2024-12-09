package br.com.mercado.main;

import br.com.mercado.model.Caixa;
import br.com.mercado.model.Estoque;
import br.com.mercado.model.FuncionarioCaixa;
import br.com.mercado.model.Produto;
import exception.ValorInvalidoException;
import exception.SaldoInsuficienteException;

public class Main {
    public static void main(String[] args) {

        //criação de produtos, já que não utilizamos db
        Produto p1 = new Produto("feijao", 100);
        Produto p2 = new Produto("arroz", 5);
        Produto p3 = new Produto("batata", 3);

        //criação funcionario
        FuncionarioCaixa f1 = new FuncionarioCaixa("Pablo");

        //criação caixa
        Caixa c1 = new Caixa("1", f1);

        //Como não estamos utilizando Banco de dados, é necessario criar um obj estoque para manipular
        Estoque e1 = new Estoque();

        //testes
        try {
            c1.retiraValorCaixa(10d);
        } catch (SaldoInsuficienteException e) {
            System.out.println("Erro " + e.getMessage());
        }

        try {
            c1.adicionaProdutosVenda(p2);
        } catch (ValorInvalidoException e) {
            System.out.println("Erro " + e.getMessage());
        }

        e1.criaProdutoEstoque("Feijao", 1);
        System.out.println(e1.getProdutosList());
    }
}