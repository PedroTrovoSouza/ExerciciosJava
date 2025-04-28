package org.example;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Venda {

    @Id
    @GeneratedValue
    private int idVenda;

    private int numVendas; //Contador vendas;
    private int numero; //Número da venda
    private String cliente;
    private double valor;

    @ManyToMany
    @JoinTable(
            name = "venda_livro",
            joinColumns = { @JoinColumn(name = "idVenda")},
            inverseJoinColumns = { @JoinColumn(name = "id")}
    )
    private List<Livro> livros = new ArrayList<Livro>();

    public void addLivro(Livro livro){
        livros.add(livro);
    }

    public void listarLivros() {
        livros.forEach(livro -> System.out.println(livro));
    }

    public int getNumVendas() {
        return numVendas;
    }

    public void setNumVendas(int numVendas) {
        this.numVendas = numVendas;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public int getIdVenda() {
        return idVenda;
    }

    public List<Livro> getLivros() {
        return livros;
    }
}