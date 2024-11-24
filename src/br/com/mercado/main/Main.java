package br.com.mercado.main;

import br.com.mercado.model.Caixa;
import br.com.mercado.model.FuncionarioCaixa;
import br.com.mercado.model.Produto;

public class Main {
    public static void main(String[] args) {
        Produto p1 = new Produto("feijao", 100.00, "consumivel", 10);
        Produto p2 = new Produto("arroz", 50.00, "consumivel", 5);
        Produto p3 = new Produto("batata", 200.00, "consumivel", 3);

        FuncionarioCaixa f1 = new FuncionarioCaixa("Pablo", "123", 10.00, "manhã");

        Caixa c1 = new Caixa("1", f1);

        c1.adicionaProdutosVenda(p1);
        c1.adicionaProdutosVenda(p2);
        System.out.println(c1.adicionaProdutosVenda(p1));

    }
