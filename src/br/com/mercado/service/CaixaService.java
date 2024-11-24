package br.com.mercado.service;

import br.com.mercado.model.Caixa;
import br.com.mercado.model.Produto;

public class CaixaService {

    public String passaVenda(Caixa caixa, Produto produto){
        boolean pagouConta = false;
        double compra = 0;
        compra += produto.getPreco();

        if (pagouConta){
            System.out.println("pagou a conta");
        }

        return ("Valor da compra atual: " + compra);
    }
}
