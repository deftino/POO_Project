package mgmt.pk;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ListaProd implements Serializable{
	private static final long serialVersionUID = 1L;
    private List<Produto> lista;
    
    public ListaProd() {
        this.lista = new ArrayList<>();
    }
    
    
    public boolean adicionar(Produto produto) {
        
        for (Produto p : lista) {
            if (p.getId().equals(produto.getId())) {
                return false; 
            }
        }
        lista.add(produto);
        return true;
    }
    

    public boolean removerProduto(String id) {
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).getId().equals(id)) {
                lista.remove(i);
                return true;
            }
        }
        return false; 
    }
    
    public Produto buscarProduto(String id) {
        for (Produto p : lista) {
            if (p.getId().equals(id)) {
                return p;
            }
        }
        return null; 
    }
    
    public boolean atualizarProduto(String id, String nome, int quantidade, float preco) {
        Produto p = buscarProduto(id);
        if (p != null) {
            p.setNome(nome);
            p.setQtd(quantidade);
            p.setPreco(preco);
            return true;
        }
        return false; 
    }    
    
    public List<Produto> getTodosProdutos() {
        return new ArrayList<>(lista);
    }
       
    public boolean isEmpty() {
        return lista.isEmpty();
    }
    
    public int getTamanho() {
        return lista.size();
    }
}
