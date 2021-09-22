package br.edu.ifpb.domain.Produto;

import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class GetProdutoById {

    @EJB
    private Produtos produtos;
    
    public String get(int id){
        return this.produtos.getById(id);
    }
}
