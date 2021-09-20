package br.edu.ifpb.domain;

import java.util.Objects;
import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class AddCliente {

    @EJB
    private Clientes clientes;
    
    public void add(Cliente cliente){
        
        Objects.requireNonNull(cliente,"O cliente não pode ser nulo");
        
        this.clientes.add(cliente);        
    }
        
}
