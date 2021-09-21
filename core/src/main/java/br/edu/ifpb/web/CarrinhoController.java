//package br.edu.ifpb.web;
//
//import br.edu.ifpb.domain.Venda.Venda;
//import br.edu.ifpb.domain.Carrinho.Carrinho;
//import br.edu.ifpb.domain.Cliente.Cliente;
//import br.edu.ifpb.domain.Produto.Produto;
//
//import javax.enterprise.context.SessionScoped;
//import javax.enterprise.inject.spi.CDI;
//import javax.inject.Inject;
//import javax.inject.Named;
//import java.io.Serializable;
//import java.util.ArrayList;
//import java.util.List;
//
//@Named
//@SessionScoped
//public class CarrinhoController implements Serializable {
//
//    @Inject
//    private Carrinho carrinho;    
//    private Venda newVenda = new Venda(new ArrayList(), -1);
//    
//    
//    public Carrinho getCarrinho() {
//        return carrinho;
//    }
//    
//    public void setCarrinho(Carrinho carrinho) {
//        this.carrinho = carrinho;
//    }
//
//    public Venda getNewVenda() {
//        return newVenda;
//    }
//
//    public void setNewVenda(Venda newVenda) {
//        this.newVenda = newVenda;
//    }
//    
//    public List<Produto> getProdutos() {
//        return this.carrinho.getCarrinho();
//    } 
//        
//    private void newCarrinho() {
//        this.carrinho = CDI.current()
//                .select(Carrinho.class)
//                .get();
//    }
//        
//    private String checkout() {
//        this.carrinho.checkout();
//        this.newCarrinho();
//        return "/Carrinho/venda?faces-redirect-true";
//    }
//    
//    private String closeVenda() {
//        this.newVenda =  new Venda(new ArrayList(), -1);
//        return "Carrinho/carrinho?faces-redirect-true";
//    }
//    
//    private String add(Produto produto) {
//        this.carrinho.addProduto(produto);
//        this.newVenda.setItems(this.carrinho.getCarrinho());
//        this.newVenda.sumTotal();
//        return "/Carrinho/carrinho";
//    }
//    
//}
