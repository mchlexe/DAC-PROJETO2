package br.edu.ifpb.domain.Produto;

import java.util.List;
import java.io.Serializable;

public interface Produtos extends Serializable {
    
    
    public void add(Produto produto);
    
    public void update(Produto produto);
    
    public void delete(Produto produto);
   
    public List<Produto> listAll();

    public List<Produto> listByDescricao(String descricao);
}
