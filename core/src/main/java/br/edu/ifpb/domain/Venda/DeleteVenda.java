package br.edu.ifpb.domain.Venda;

import javax.ejb.Stateless;
import javax.ejb.EJB;


@Stateless
public class DeleteVenda {
    
    @EJB
    private Vendas vendas;
    
    public void delete(Venda venda){
        this.vendas.delete(venda);
    };
    
}
