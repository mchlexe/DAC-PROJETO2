package br.edu.ifpb.domain.Produto;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Produto {

    private Integer id;
    private String descricao;
    private Double preco;


    public Produto(int id,String descricao,Double preco) {
        this.id = id;
        this.descricao = descricao;
        this.preco = preco;
    }
    
    
    public Produto(Produto produto) {
        this.id = produto.id;
        this.descricao = produto.descricao;
        this.preco = produto.preco;
    }

    public Integer getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

}
