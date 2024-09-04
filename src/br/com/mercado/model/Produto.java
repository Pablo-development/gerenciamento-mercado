import java.util.Date;
import lombok.*;

@Setter
@Getter
@ToString
public class Produto {

    private String nome;
    private String descricao;
    private double preco;
    private String tipo;
    private Date dataValidade;
    private int quantidade;

    public Produto(String nome, double preco, String tipo, int quantidade){
        this.nome = nome;
        this.preco = preco;
        this.tipo = tipo;
        this.quantidade = quantidade;
    }
}
