package br.edu.ifpb.web.jsf;

import br.edu.ifpb.domain.Produto.Produto;
import br.edu.ifpb.domain.Produto.ListAllProdutos;
import br.edu.ifpb.domain.Produto.ListByDescricaoProduto;
import br.edu.ifpb.domain.Produto.AddProduto;
import br.edu.ifpb.domain.Produto.DeleteProduto;
import br.edu.ifpb.domain.Produto.UpdateProduto;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;


@Named
@SessionScoped
public class ProdutoController implements Serializable {
    
    private Produto produto = new Produto(0, "", 0.0);
    private List<Produto> resultProdutos = new ArrayList<>();
    
    @Inject
    private AddProduto addProduto;
    
    @Inject
    private UpdateProduto updateProduto;
    
    @Inject
    private DeleteProduto deleteProduto;
    
    @Inject
    private ListAllProdutos  listAllProdutos;
    
    @Inject
    private ListByDescricaoProduto  listByDescricaoProduto;
    
    
     public List<Produto> getResultProdutos() {
        return resultProdutos;
    }
    public void setResultProdutos(List<Produto> resultProdutos) {
        this.resultProdutos = resultProdutos;
    }    
    
    public String add() {
        
        if (this.produto.getId() == 0) {
            
            this.addProduto.add(this.produto);
            
        } else {            
            
            this.updateProduto.update(produto);
        }
        
        this.produto = new Produto(0, "", 0.0);
        return "/Produto/list?faces-redirect=true";         
    }
    
    public String update(Produto produto) {
        this.produto = produto;
        return "/Produto/edit?faces-redirect=true";
    }
    
    public String delete(Produto produto) {
        
        this.deleteProduto.delete(produto);
        return "/Produto/list?faces-redirect=true";
    }
    
    public List<Produto> listAllProdutos() {
        
        return this.listAllProdutos.list();
    }
    
    public String listByDescricaoProduto() {
        
        this.resultProdutos = listByDescricaoProduto.list(this.produto.getDescricao());
        this.produto = new Produto(0, "", 0.0);
        return "/Produto/search";
    }
    
    public Produto getProduto() {
        return produto;
    }
        
}