
package br.edu.ifpb.domain.Venda;

import java.io.Serializable;
import java.util.List;


public interface Vendas extends Serializable {
    
    public void add(Venda venda);
    
    public void update(Venda venda);
    
    public void delete(Venda venda);
   
    public List<Venda> list();    
    
}