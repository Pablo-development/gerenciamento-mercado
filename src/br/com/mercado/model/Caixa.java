package br.com.mercado.model;

import exception.ValorInvalidoException;
import exception.SaldoInsuficienteException;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
public class Caixa {

    private String numeracaoCaixa;
    private double saldoCaixa;
    private FuncionarioCaixa operadorCaixa;
    private double totalCompra;
    private List<Produto> listaCompras = new ArrayList<>();

    private static final int PAGAMENTO_DINHEIRO = 1;
    private static final int PAGAMENTO_CARTAO_CREDITO = 2;
    private static final int PAGAMENTO_CARTAO_DEBITO = 3;

    public Caixa(String numeracaoCaixa, FuncionarioCaixa operadorCaixa) {
        this.numeracaoCaixa = numeracaoCaixa;
        this.operadorCaixa = operadorCaixa;
    }

    public void adicionaProdutosVenda(Produto produto) {
        if (produto == null || produto.getPreco() < 0) {
            throw new ValorInvalidoException("Produto inválido ou preço negativo.");
        }

        totalCompra += produto.getPreco();
        listaCompras.add(produto);
        System.out.println("Produto adicionado: " + produto.getNome() + " | Valor: R$ " + produto.getPreco());
        System.out.println("Valor total da compra: R$ " + totalCompra);
        extrato();
    }

    public void retiraValorCaixa(double valor) {
        if (valor < 0) {
            throw new ValorInvalidoException("O valor de retirada não pode ser negativo.");
        }
        if (valor > saldoCaixa) {
            throw new SaldoInsuficienteException("Saldo insuficiente no caixa.");
        }

        saldoCaixa -= valor;
        System.out.println("Valor retirado: R$ " + valor);
        System.out.println("Saldo atual em caixa: R$ " + saldoCaixa);
    }

    public void adicionaValorCaixa(double valor) {
        if (valor < 0) {
            throw new ValorInvalidoException("O valor a ser adicionado não pode ser negativo.");
        }

        saldoCaixa += valor;
        System.out.println("Valor adicionado: R$ " + valor);
        System.out.println("Saldo atual em caixa: R$ " + saldoCaixa);
    }

    public List<Produto> extrato() {
        System.out.println("Produtos: ");
        listaCompras.forEach(produto -> System.out.println("- " + produto.getNome() + " | Preço: R$ " + produto.getPreco()));
        System.out.println("Total da compra: R$ " + totalCompra);
        return new ArrayList<>(listaCompras);
    }

    public void processaPagamento(int formaPagamento) {
        if (listaCompras.isEmpty()) {
            System.out.println("Nenhum produto na lista de compras. Adicione produtos antes de processar o pagamento.");
            return;
        }

        switch (formaPagamento) {
            case PAGAMENTO_DINHEIRO:
                saldoCaixa += totalCompra;
                System.out.println("Pagamento em dinheiro recebido. Total: R$ " + totalCompra);
                break;
            case PAGAMENTO_CARTAO_CREDITO:
            case PAGAMENTO_CARTAO_DEBITO:
                System.out.println("Pagamento no cartão recebido. Total: R$ " + totalCompra);
                break;
            default:
                System.out.println("Forma de pagamento inválida.");
        }

        totalCompra = 0;
        listaCompras.clear();
        System.out.println("Compra finalizada");
    }
}

