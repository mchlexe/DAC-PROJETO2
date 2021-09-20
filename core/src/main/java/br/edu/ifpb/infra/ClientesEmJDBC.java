package br.edu.ifpb.infra;

import br.edu.ifpb.domain.Cliente.Clientes;
import br.edu.ifpb.domain.Cliente.Cliente;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;

@Stateless
public class ClientesEmJDBC implements Clientes {

    private Connection connection;
        
    
    public ClientesEmJDBC() throws SQLException {
        
        try {
            Class.forName("org.postgresql.Driver");
            this.connection = DriverManager.getConnection(
                "jdbc:postgresql://host-banco:5432/projeto2",
                "postgres","123"
            );
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ClientesEmJDBC.class.getName()).log(Level.SEVERE,null,ex);
        }
        
    }        
    
    @Override
    public void add(Cliente cliente) {
        try {
            PreparedStatement statement = connection
                .prepareStatement(
                    "INSERT INTO CLIENTE (cpf, nome) VALUES(?,?) RETURNING *"
                );
            statement.setString(1,cliente.getCpf());
            statement.setString(2,cliente.getNome());
            statement.executeQuery();
            
        } catch (SQLException ex) {
            Logger.getLogger(ClientesEmJDBC.class.getName()).log(Level.SEVERE,null,ex);
        }
    }
    
    @Override
    public void update(Cliente cliente) {
        
        try {
            PreparedStatement statement = connection
                .prepareStatement(
                    "UPDATE CLIENTE SET NOME = ?, CPF = ? WHERE ID = ?"
                );
           
            statement.setString(1, cliente.getNome());
            statement.setString(2, cliente.getCpf());
            statement.setInt(3, cliente.getId());
            statement.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(ClientesEmJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public void delete(Cliente cliente) {
        
        try {
            PreparedStatement statement = connection
                .prepareStatement(
                    "DELETE FROM CLIENTE WHERE ID = ?"
                );
           
            statement.setInt(1, cliente.getId());
            statement.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(ClientesEmJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public Cliente criarCliente(ResultSet result) throws SQLException{
        
        int id = result.getInt("Id");
        String nome = result.getString("Nome");
        String Cpf = result.getString("Cpf");
        return new Cliente(id, nome, Cpf);
    }
        
    @Override
    public List<Cliente> list() {
        try {
            List<Cliente> clientes = new ArrayList<>();
            
            ResultSet result = connection
                    .prepareStatement(
                    "SELECT * FROM CLIENTE"
                ).executeQuery();
            while (result.next()) {
                clientes.add(
                    criarCliente(result)
                );
            }
            return clientes;
            
        } catch (SQLException ex) {
            return Collections.EMPTY_LIST;
        }
    }

}
