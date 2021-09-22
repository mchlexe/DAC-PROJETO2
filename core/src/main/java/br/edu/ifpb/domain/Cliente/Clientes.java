package br.edu.ifpb.domain.Cliente;

import java.util.List;
import java.io.Serializable;

public interface Clientes extends Serializable {
    
    
    public void add(Cliente cliente);
    
    public void update(Cliente cliente);
    
    public void delete(Cliente cliente);
   
    public List<Cliente> list();
    
    public String getById(int id);
}
