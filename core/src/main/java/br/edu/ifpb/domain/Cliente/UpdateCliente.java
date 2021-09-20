package br.edu.ifpb.domain.Cliente;


import javax.ejb.Stateless;
import javax.ejb.EJB;

/**
 *
 * @author mchlm
 */

@Stateless
public class UpdateCliente {
    
    @EJB
    private Clientes clientes;
    
    public void update(Cliente cliente) {
        this.clientes.update(cliente);
    }
}
