
package br.edu.ifpb.infra;


import br.edu.ifpb.domain.Carrinho.Carrinho;
import br.edu.ifpb.domain.Cliente.Cliente;
import br.edu.ifpb.domain.Venda.Venda;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.ejb.Remove;
import javax.ejb.Stateful;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Stateful
public class CarrinhoEmJDBC implements Carrinho {
    
    private final List<Venda> vendas = new ArrayList<>();
    
    private Connection connection;        
    
    public CarrinhoEmJDBC() throws SQLException {
        
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
     public void addVenda(Venda venda) {
         this.vendas.add(venda);
     }
     
    @Override
     public void deleteVenda(Venda venda) {
         this.vendas.remove(venda);
     }
     
    @Override
    public List<Venda> getCarrinho() {
        return Collections.unmodifiableList(this.vendas);
    }
    
    
    @Remove
    @Override
    public void checkout() {
         try {            
            for (Venda venda : vendas) {
                PreparedStatement statement = connection
                    .prepareStatement(
                        "INSERT INTO VENDA (produto, quantidade, cliente) VALUES(?,?,?) RETURNING *"
                    );
                statement.setInt(1,venda.getProduto());
                statement.setInt(2,venda.getQuantidade());
                statement.setInt(3,venda.getCliente());
                statement.executeQuery();
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(CarrinhoEmJDBC.class.getName()).log(Level.SEVERE,null,ex);
        }   
    }
    
}
