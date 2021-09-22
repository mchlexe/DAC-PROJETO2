package br.edu.ifpb.web.jsf;

import br.edu.ifpb.domain.Carrinho.Carrinho;
import br.edu.ifpb.domain.Venda.Venda;
import javax.enterprise.context.SessionScoped;
import javax.enterprise.inject.spi.CDI;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@SessionScoped
public class CarrinhoController implements Serializable {
    
    @Inject
    private Carrinho carrinho;
    private Venda venda = new Venda(0, 0, 0);
    
    public String add() {
        this.carrinho.addVenda(this.venda);        
        return "/Carrinho/carrinho?faces-redirect=true"; 
    }
    
    public String delete() {
        this.carrinho.deleteVenda(this.venda);        
        return "/Carrinho/carrinho?faces-redirect=true"; 
    }
    
    private void newCarrinho() {
        this.carrinho = CDI.current()
                .select(Carrinho.class)
                .get();
    }
    
    public String finish(){
        this.carrinho.checkout();
        newCarrinho();
        
        return "/Carrinho/carrinho?faces-redirect=true";
    }
    
    public List<Venda> list() {
        return this.carrinho.getCarrinho();
    }
    
    public Venda getVenda() {
        return this.venda;
    }
    
    public void setvenda(Venda venda) {
        this.venda = venda;
    }
    
}

