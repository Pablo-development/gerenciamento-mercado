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

    public Produto(String nome, double preco, String tipo){
        this.nome = nome;
        this.preco = preco;
        this.tipo = tipo;
    }
}
