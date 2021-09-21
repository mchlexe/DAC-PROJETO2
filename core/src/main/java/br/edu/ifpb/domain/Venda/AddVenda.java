package br.edu.ifpb.domain.Venda;

import java.util.Objects;
import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class AddVenda {

    @EJB
    private Vendas vendas;
    
    public void add(Venda venda){
        
        Objects.requireNonNull(venda, "A venda não pode ser nula");
        
        this.vendas.add(venda);        
    }
        
}
