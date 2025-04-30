package com.exercicio1.exerciciosSpring.Service;

import com.exercicio1.exerciciosSpring.Dto.ProdutoDto;
import com.exercicio1.exerciciosSpring.Entity.Produto;
import com.exercicio1.exerciciosSpring.Repository.ProdutoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepositorio produtoRepositorio;

    public ProdutoDto postProduto(ProdutoDto novoProduto){
        produtoRepositorio.save(new Produto(novoProduto));
        return novoProduto;
    }

    public List<Produto> pegarTodosProdutos(){
        List<Produto> produtos;
        produtos = produtoRepositorio.findAll();
        return produtos;
    }

    public Double atualizarPreco(float id, double preco) {
        return (double) produtoRepositorio.atualizarPreco(id, preco);
    }

    public int atualizarEstoque(float id, int qtdEstoque){
        return produtoRepositorio.atualizarEstoque(id, qtdEstoque);
    }

    public void exluirUsuario(float id){
        produtoRepositorio.deleteById(id);
    }

}
