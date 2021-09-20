package br.edu.ifpb.domain.Produto;

import javax.ejb.Stateless;
import javax.ejb.EJB;

/**
 *
 * @author mchlm
 */

@Stateless
public class UpdateProduto {
    
    @EJB
    private Produtos produtos;
    
    public void update(Produto produto) {
        this.produtos.update(produto);
    }
}
