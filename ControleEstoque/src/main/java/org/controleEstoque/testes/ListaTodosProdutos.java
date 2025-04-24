package org.controleEstoque.testes;

import org.controleEstoque.modelo.Produto;
import org.controleEstoque.repositorio.RepositorioProdutos;

import java.util.List;

public class ListaTodosProdutos {
    public static void main(String[] args) {

        RepositorioProdutos repoProduto = new RepositorioProdutos();
        List<Produto> produtos = repoProduto.buscarTodosProdutos();

        for (int i = 0; i < produtos.size(); i++) {
            System.out.println("Nome do produto: " + produtos.get(i).getNome());
            System.out.println("Descrição do produto: " + produtos.get(i).getDescricao());
            System.out.println("Preço do produto: " + produtos.get(i).getPreco());
            System.out.println(" ");
        }

    }
}
