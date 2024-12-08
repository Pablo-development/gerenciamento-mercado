package br.com.mercado.main;

import br.com.mercado.model.Caixa;
import br.com.mercado.model.FuncionarioCaixa;
import br.com.mercado.model.Produto;
import exception.ValorInvalidoException;
import exception.SaldoInsuficienteException;

public class Main {
    public static void main(String[] args) {

        //criação de produtos, já que não utilizamos db
        Produto p1 = new Produto("feijao", 100.00, "consumivel", 10);
        Produto p2 = new Produto("arroz", 50.00, "consumivel", 5);
        Produto p3 = new Produto("batata", 200.00, "consumivel", 3);

        //criação funcionario
        FuncionarioCaixa f1 = new FuncionarioCaixa("Pablo", "123", 10.00, "manhã");

        //criação caixa
        Caixa c1 = new Caixa("1", f1);

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

    }
}