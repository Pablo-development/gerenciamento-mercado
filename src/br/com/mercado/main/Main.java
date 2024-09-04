public class Main {
    public static void main(String[] args) {
        FuncionarioCaixa f1 = new FuncionarioCaixa("Pablo", "11370878974",
                2000.00, "matutino");

        Caixa caixa1 = new Caixa("1");

        Produto produto1 = new Produto("Feijao", 10.00, "Consumivel", 10);

        System.out.println(caixa1.passaVenda(produto1));
        System.out.println(caixa1.passaVenda(produto1));
        System.out.println(caixa1.passaVenda(produto1));
        System.out.println(caixa1.passaVenda(produto1));

        caixa1.setOperadorCaixa(f1);
        System.out.println(caixa1.getOperadorCaixa().cpf);
    }
}