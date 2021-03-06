package br.edu.ifpb.domain.Cliente;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Cliente {

    private int id;
    private String cpf;
    private String nome;


    public Cliente(String cpf,String nome) {
        this(-1,cpf,nome);
    }

    public Cliente(int id,String nome,String cpf) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

}
