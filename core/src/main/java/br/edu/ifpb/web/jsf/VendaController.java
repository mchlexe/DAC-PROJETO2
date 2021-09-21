package br.edu.ifpb.web.jsf;

import br.edu.ifpb.domain.Venda.Venda;
import br.edu.ifpb.domain.Venda.AddVenda;
import br.edu.ifpb.domain.Venda.DeleteVenda;
import br.edu.ifpb.domain.Venda.UpdateVenda;
import br.edu.ifpb.domain.Venda.ListVendas;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;


@Named
@SessionScoped
public class VendaController implements Serializable {
    
    @Inject
    private AddVenda addVenda;
    
    @Inject
    private UpdateVenda updateVenda;
    
    @Inject
    private DeleteVenda deleteVenda;
    
    @Inject
    private ListVendas  listVendas;
    
    private Venda venda = new Venda(0, 0, 0, 0);
    
    public String add() {
        
        if (this.venda.getId() == 0) {
            
            this.addVenda.add(this.venda);
            
        } else {            
            
            this.updateVenda.update(venda);
        }
        
        this.venda = new Venda(0, 0, 0, 0);
        return "/Venda/list?faces-redirect=true";         
    }
    
    public String update(Venda venda) {
        this.venda = venda;
        return "/Venda/edit?faces-redirect=true";
    }
    
    public String delete(Venda venda) {
        
        this.deleteVenda.delete(venda);
        return "/Venda/list?faces-redirect=true";
    }
    
    public List<Venda> list() {
        
        return this.listVendas.list();
    }
    
    public Venda getVenda() {
        return venda;
    }
        
}