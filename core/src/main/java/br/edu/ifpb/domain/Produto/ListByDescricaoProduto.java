package br.edu.ifpb.domain.Produto;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class ListByDescricaoProduto {

    @EJB
    private Produtos produtos;
    
    public List<Produto> list(String descricao){
        return this.produtos.listByDescricao(descricao);
    }
}
