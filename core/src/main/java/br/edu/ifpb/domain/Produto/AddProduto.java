package br.edu.ifpb.domain.Produto;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.Objects;

@Stateless
public class AddProduto {

    @EJB
    private Produtos produtos;
    
    public void add(Produto produto){
        
        Objects.requireNonNull(produto, "O produto não pode ser nulo");
        
        this.produtos.add(produto);        
    }
        
}
