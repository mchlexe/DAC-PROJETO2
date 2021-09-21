package br.edu.ifpb.infra;

import br.edu.ifpb.domain.Venda.Vendas;
import br.edu.ifpb.domain.Venda.Venda;
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
public class VendaEmJDBC implements Vendas {

    private Connection connection;
        
    
    public VendaEmJDBC() throws SQLException {
        
        try {
            Class.forName("org.postgresql.Driver");
            this.connection = DriverManager.getConnection(
                "jdbc:postgresql://host-banco:5432/projeto2",
                "postgres","123"
            );
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(VendaEmJDBC.class.getName()).log(Level.SEVERE,null,ex);
        }
        
    }        
    
    @Override
    public void add(Venda venda) {
        try {
            PreparedStatement statement = connection
                .prepareStatement(
                    "INSERT INTO VENDA (produto, quantidade, cliente) VALUES(?,?,?) RETURNING *"
                );
            statement.setInt(1,venda.getProduto());
            statement.setInt(2,venda.getQuantidade());
            statement.setInt(3,venda.getCliente());
            statement.executeQuery();
            
        } catch (SQLException ex) {
            Logger.getLogger(VendaEmJDBC.class.getName()).log(Level.SEVERE,null,ex);
        }
    }
    
    @Override
    public void update(Venda venda) {
        
        try {
            PreparedStatement statement = connection
                .prepareStatement(
                    "UPDATE VENDA SET produto = ?, quantidade = ?, cliente = ? WHERE id = ?"
                );
           
            statement.setInt(1,venda.getProduto());
            statement.setInt(2,venda.getQuantidade());
            statement.setInt(3,venda.getCliente());
            statement.setInt(4, venda.getId());
            statement.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(VendaEmJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public void delete(Venda venda) {
        
        try {
            PreparedStatement statement = connection
                .prepareStatement(
                    "DELETE FROM VENDA WHERE id = ?"
                );
           
            statement.setInt(1, venda.getId());
            statement.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(VendaEmJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public Venda criarVenda(ResultSet result) throws SQLException{
        
        int id = result.getInt("id");
        int produto = result.getInt("produto");
        int quantidade = result.getInt("quantidade");
        int cliente = result.getInt("cliente");
        
        return new Venda(id, produto, quantidade, cliente);
    }
        
    @Override
    public List<Venda> list() {
        try {
            List<Venda> vendas = new ArrayList<>();
            
            ResultSet result = connection
                    .prepareStatement(
                    "SELECT *"
                    + "FROM VENDA"
                ).executeQuery();
            while (result.next()) {
                vendas.add(
                    criarVenda(result)
                );
            }
            return vendas;
            
        } catch (SQLException ex) {
            return Collections.EMPTY_LIST;
        }
    }

}
