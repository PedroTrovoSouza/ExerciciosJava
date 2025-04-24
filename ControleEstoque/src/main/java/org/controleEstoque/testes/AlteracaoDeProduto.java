package org.controleEstoque.testes;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.controleEstoque.repositorio.RepositorioProdutos;

public class AlteracaoDeProduto {
    public static void main(String[] args) {

        RepositorioProdutos repoProduto = new RepositorioProdutos();

        repoProduto.alterarProduto(1, 345.00);
    }
}
