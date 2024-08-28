import lombok.*;
@Getter
@Setter
public class Caixa  {

    private String numeracaoCaixa;
    private double saldoCaixa;
    private FuncionarioCaixa operadorCaixa;
    double compra = 0;

    public Caixa(String numeracaoCaixa){
        this.numeracaoCaixa = numeracaoCaixa;
    }

    public String passaVenda(Produto produto){
        compra += produto.getPreco();

        return ("Valor da compra atual: " + compra);
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
