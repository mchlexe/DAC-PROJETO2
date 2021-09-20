package br.edu.ifpb.domain.Cliente;

import javax.ejb.Stateless;
import javax.ejb.EJB;

/**
 *
 * @author mchlm
 */

@Stateless
public class DeleteCliente {
    
    @EJB
    private Clientes clientes;
    
    public void delete(Cliente cliente){
        this.clientes.delete(cliente);
    };
    
}
