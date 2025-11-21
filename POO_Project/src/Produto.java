import java.io.Serial;
import java.io.Serializable;

public class Produto implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    private String nome;
    private String id;
    private int quantidade;
    private float preco;
    
    public Produto(String nome, String id, int quantidade, float preco) {
        this.nome = nome;
        this.id = id;
        this.quantidade = quantidade;
        this.preco = preco;
    }
    
    public void setNome(String nm) {
        this.nome = nm;
    }
    
    public void setId(String id) {
        this.id = id;
    }
    
    public void setQtd(int qtd) {
        this.quantidade = qtd;
    }
    
    public void setPreco(float price) {
        this.preco = price;
    }
    
    public String getNome() {
        return this.nome;
    }
    
    public String getId() {
        return this.id;
    }
    
    public int getQtd() {
        return this.quantidade;
    }
    
    public float getPreco() {
        return this.preco;
    }
    
    public static Produto newProduto(String nome, String id, int quantidade, float preco) {
        return new Produto(nome, id, quantidade, preco);
    }
}