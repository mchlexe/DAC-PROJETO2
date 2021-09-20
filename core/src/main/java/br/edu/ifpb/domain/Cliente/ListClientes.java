package br.edu.ifpb.domain.Cliente;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class ListClientes {

    @EJB
    private Clientes clientes;
    
    public List<Cliente> list(){
        return this.clientes.list();
    }
}
