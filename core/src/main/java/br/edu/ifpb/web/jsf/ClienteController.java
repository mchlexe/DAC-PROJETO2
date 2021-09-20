package br.edu.ifpb.web.jsf;

import br.edu.ifpb.domain.Cliente.Cliente;
import br.edu.ifpb.domain.Cliente.ListClientes;
import br.edu.ifpb.domain.Cliente.AddCliente;
import br.edu.ifpb.domain.Cliente.DeleteCliente;
import br.edu.ifpb.domain.Cliente.UpdateCliente;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;


@Named
@SessionScoped
public class ClienteController implements Serializable {
    
    @Inject
    private AddCliente addCliente;
    
    @Inject
    private UpdateCliente updateCliente;
    
    @Inject
    private DeleteCliente deleteCliente;
    
    @Inject
    private ListClientes  listClientes;
    
    private Cliente cliente = new Cliente(0, "", "");
    
    public String add() {
        
        if (this.cliente.getId() == 0) {
            
            this.addCliente.add(this.cliente);
            
        } else {            
            
            this.updateCliente.update(cliente);
        }
        
        this.cliente = new Cliente(0, "", "");
        return "/Cliente/list?faces-redirect=true";         
    }
    
    public String update(Cliente cliente) {
        this.cliente = cliente;
        return "/Cliente/edit?faces-redirect=true";
    }
    
    public String delete(Cliente cliente) {
        
        this.deleteCliente.delete(cliente);
        return "/Cliente/list?faces-redirect=true";
    }
    
    public List<Cliente> list() {
        
        return this.listClientes.list();
    }
    
    public Cliente getCliente() {
        return cliente;
    }
        
}