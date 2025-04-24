package org.controleEstoque.testes;

import org.controleEstoque.repositorio.RepositorioProdutos;

public class RemocaoDeProduto {
    public static void main(String[] args) {

        RepositorioProdutos repoProduto = new RepositorioProdutos();

        repoProduto.removerProduto(3);

    }
}
