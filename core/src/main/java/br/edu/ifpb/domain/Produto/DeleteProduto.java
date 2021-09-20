package br.edu.ifpb.domain.Produto;

import javax.ejb.Stateless;
import javax.ejb.EJB;

/**
 *
 * @author mchlm
 */

@Stateless
public class DeleteProduto {
    
    @EJB
    private Produtos produtos;
    
    public void delete(Produto produto){
        this.produtos.delete(produto);
    };
    
}
