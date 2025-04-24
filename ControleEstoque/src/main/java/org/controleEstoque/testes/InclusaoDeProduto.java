package org.controleEstoque.testes;

import org.controleEstoque.modelo.Produto;
import org.controleEstoque.repositorio.RepositorioProdutos;

public class InclusaoDeProduto {
    public static void main(String[] args) {
        RepositorioProdutos repoProduto = new RepositorioProdutos();

        Produto prop = new Produto();
        Produto prop2 = new Produto();
        Produto prop3 = new Produto();

        prop.setNome("Panela");
        prop.setDescricao("Panela de Pressão 10 litros");
        prop.setPreco(56.80);

        prop2.setNome("Cama");
        prop2.setDescricao("Cama de casal big");
        prop2.setPreco(450.68);

        prop3.setNome("Caixa de som");
        prop3.setDescricao("Caixa de som JBL");
        prop3.setPreco(160.00);

        repoProduto.salvarNoBanco(prop);
        repoProduto.salvarNoBanco(prop2);
        repoProduto.salvarNoBanco(prop3);
    }
}
