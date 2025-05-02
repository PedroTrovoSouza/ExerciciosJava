package com.exercicio1.exerciciosSpring.Controller;

import com.exercicio1.exerciciosSpring.Dto.EstoqueDto;
import com.exercicio1.exerciciosSpring.Dto.PrecoDto;
import com.exercicio1.exerciciosSpring.Dto.ProdutoDto;
import com.exercicio1.exerciciosSpring.Entity.Produto;
import com.exercicio1.exerciciosSpring.Service.ProdutoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produto")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @PostMapping
    public ResponseEntity<ProdutoDto> postProduto(@RequestBody @Valid ProdutoDto novoProduto){
        ProdutoDto produtoCadastrado = produtoService.postProduto(novoProduto);

        return ResponseEntity.status(201).body(produtoCadastrado);
    }

    @GetMapping
    public ResponseEntity<List<Produto>> pegarTodosProdutos(){
        List<Produto> produtos =  produtoService.pegarTodosProdutos();

        return ResponseEntity.ok().body(produtos);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Double> patchPreco(@PathVariable float id, @RequestBody PrecoDto dto) {
        Double precoAtualizado = produtoService.atualizarPreco(id, dto.preco());

        return ResponseEntity.ok(precoAtualizado);
    }

    @PatchMapping("/estoque/{id}")
    public ResponseEntity<Integer> patchEstoque(@PathVariable float id, @RequestBody EstoqueDto dto) {
        int estoqueAtualizado = produtoService.atualizarEstoque(id, dto.quantidade());

        return ResponseEntity.ok(estoqueAtualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduto(@PathVariable float id){
        produtoService.exluirUsuario(id);

        return ResponseEntity.status(204).build();
    }


}
