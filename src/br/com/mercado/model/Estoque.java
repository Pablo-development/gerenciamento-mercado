package br.com.mercado.model;
import exception.ValorInvalidoException;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Estoque {

    private List<Produto> produtosList;

    public Estoque(){
        this.produtosList = new ArrayList<>();
    }

    public Produto buscaProduto(Produto produto){
        if (produtosList.isEmpty()){
            throw new IllegalStateException("Estoque vazio");
        }
        if (produtosList.contains(produto)){
            return produto;
        } else {
            throw new IllegalArgumentException("Produto inexistente no estoque");
        }
    }

    public void criaProdutoEstoque(String nome, int quantidade){
        if (quantidade <= 0) {
            throw new IllegalArgumentException("Quantidade deve ser maior que zero.");
        }
        Produto p1 = new Produto(nome, quantidade);
        produtosList.add(p1);
        System.out.println("Produto criado com sucesso! ");
    }

    public void retiraQuantidadeEstoque(Caixa caixa) {
        if (produtosList.getFirst().getQuantidade() <= 0)
            throw new ValorInvalidoException("Quantidade insuficiente para retirada.");

        produtosList.getFirst().setQuantidade(-1);

        produtosList.remove(produtosList.getFirst());

        if (produtosList.isEmpty()){
            System.out.println("Baixa em estoque efetuada");
            return;
        }
        retiraQuantidadeEstoque(caixa);
    }

    public void editaDescricao(String descricao, Produto produto){
        produto.setDescricao(descricao);
        System.out.println("Descrição alterada");

    }

    public void excluiProduto(Produto produto){
        if(produtosList.isEmpty()){
            throw new IllegalStateException("Erro: Não há produtos no estoque para remover.");
        }
        if (produtosList.contains(produto)) {
            produtosList.remove(produto);
            System.out.println("Produto excluido");
        } else {
            throw new IllegalArgumentException("Produto inexistente no estoque");
        }

    }
}
