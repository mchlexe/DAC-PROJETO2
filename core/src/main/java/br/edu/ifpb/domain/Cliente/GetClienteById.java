package br.edu.ifpb.domain.Cliente;

import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class GetClienteById {

    @EJB
    private Clientes clientes;
    
    public String get(int id){
        return this.clientes.getById(id);
    }
}
