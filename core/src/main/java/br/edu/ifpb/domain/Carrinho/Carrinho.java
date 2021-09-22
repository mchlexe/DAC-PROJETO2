
package br.edu.ifpb.domain.Carrinho;
import br.edu.ifpb.domain.Venda.Venda;
import java.io.Serializable;
import java.util.List;


public interface Carrinho extends Serializable {
    
    public void addVenda(Venda venda);
    
    public void deleteVenda(Venda venda);
    
    public List<Venda> getCarrinho();
    
    public void checkout();
    
}
