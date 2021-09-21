package br.edu.ifpb.domain.Venda;


import javax.ejb.Stateless;
import javax.ejb.EJB;

/**
 *
 * @author mchlm
 */

@Stateless
public class UpdateVenda {
    
    @EJB
    private Vendas vendas;
    
    public void update(Venda venda) {
        this.vendas.update(venda);
    }
}
