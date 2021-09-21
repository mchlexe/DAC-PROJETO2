package br.edu.ifpb.domain.Venda;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class ListVendas {

    @EJB
    private Vendas vendas;
    
    public List<Venda> list(){
        return this.vendas.list();
    }
}
