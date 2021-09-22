package br.edu.ifpb.infra;

import br.edu.ifpb.domain.Produto.Produtos;
import br.edu.ifpb.domain.Produto.Produto;
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
public class ProdutosEmJDBC implements Produtos {

    private Connection connection;
        
    
    public ProdutosEmJDBC() throws SQLException {
        
        try {
            Class.forName("org.postgresql.Driver");
            this.connection = DriverManager.getConnection(
                "jdbc:postgresql://host-banco:5432/projeto2",
                "postgres","123"
            );
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ProdutosEmJDBC.class.getName()).log(Level.SEVERE,null,ex);
        }
        
    }        
    
    @Override
    public void add(Produto produto) {
        try {
            PreparedStatement statement = connection
                .prepareStatement(
                    "INSERT INTO PRODUTO (descricao, preco) VALUES(?,?) RETURNING *"
                );
            statement.setString(1,produto.getDescricao());
            statement.setDouble(2,produto.getPreco());
            statement.executeQuery();
            
        } catch (SQLException ex) {
            Logger.getLogger(ProdutosEmJDBC.class.getName()).log(Level.SEVERE,null,ex);
        }
    }
    
    @Override
    public void update(Produto produto) {
        
        try {
            PreparedStatement statement = connection
                .prepareStatement(
                    "UPDATE PRODUTO SET DESCRICAO = ?, PRECO = ? WHERE ID = ?"
                );
           
            statement.setString(1, produto.getDescricao());
            statement.setDouble(2,produto.getPreco());
            statement.setInt(3, produto.getId());
            statement.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(ProdutosEmJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public void delete(Produto produto) {
        
        try {
            PreparedStatement statement = connection
                .prepareStatement(
                    "DELETE FROM PRODUTO WHERE ID = ?;"
                );
           
            statement.setInt(1, produto.getId());
            statement.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(ProdutosEmJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public Produto criarCliente(ResultSet result) throws SQLException{
        
        int id = result.getInt("Id");
        String descricao = result.getString("Descricao");
        Double preco = result.getDouble("Preco");
        return new Produto(id, descricao, preco);
    }
        
    @Override
    public List<Produto> listAll() {
        try {
            List<Produto> produtos = new ArrayList<>();
            
            ResultSet result = connection
                    .prepareStatement(
                    "SELECT * FROM PRODUTO;"
                ).executeQuery();
            while (result.next()) {
                produtos.add(
                    criarCliente(result)
                );
            }
            return produtos;
            
        } catch (SQLException ex) {
            return Collections.EMPTY_LIST;
        }
    }
        
    @Override
    public List<Produto> listByDescricao(String descricao) {
        try {
            List<Produto> produtos = new ArrayList<>();
            
            PreparedStatement statement = connection
                    .prepareStatement(
                    "SELECT * FROM PRODUTO WHERE DESCRICAO LIKE ?;"
                );
            statement.setString(1, '%' + descricao + '%');
            statement.executeQuery();
            
            ResultSet result = statement.getResultSet();
            
            while (result.next()) {
                produtos.add(
                    criarCliente(result)
                );
            };
            return produtos;
            
        } catch (SQLException ex) {
            return Collections.EMPTY_LIST;
        }
    }
    
    @Override
    public String getById(int id) {
        try {
            String descricao = "";
            
            PreparedStatement statement = connection
                    .prepareStatement(
                    "SELECT DESCRICAO FROM PRODUTO WHERE ID = ?;"
                );
            statement.setInt(1, id);
            statement.executeQuery();
            
            ResultSet result = statement.getResultSet();
            
            while (result.next()) {
                descricao = result.getString("descricao");
            }    
            
            return descricao;
            
        } catch (SQLException ex) {
            return "Erro em getById - ProdutosEmJDBC";
        }
    }

}
