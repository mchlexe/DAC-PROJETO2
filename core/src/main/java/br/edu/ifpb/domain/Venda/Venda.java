package br.edu.ifpb.domain.Venda;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Venda {
    
    private int id;
    private int produto;
    private int quantidade;
    private int cliente;
  
    public Venda(int id, int produto, int quantidade, int cliente) {
        this.id = id;
        this.produto = produto;
        this.quantidade = quantidade;
        this.cliente = cliente;
    }
    
    public Venda(int produto, int quantidade, int cliente) {
        this(-1,produto,quantidade,cliente);
    }    


    public int getId() {
        return id;
    }

    public int getQuantidade() {
        return quantidade;
    } 
        
    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public int getProduto() {
        return produto;
    }
   
    public void setProduto(int produto) {
        this.produto = produto; 
    }
      
    public int getCliente() {
        return cliente;
    }

    public void setCliente(int cliente) {
        this.cliente = cliente;
    }  
   
}
