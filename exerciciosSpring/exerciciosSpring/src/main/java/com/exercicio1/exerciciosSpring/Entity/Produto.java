package com.exercicio1.exerciciosSpring.Entity;

import com.exercicio1.exerciciosSpring.Dto.ProdutoDto;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    float id;

    @NotBlank
    @Size(min = 3, max = 100)
    private String nome;

    @PositiveOrZero
    private int quantidade;

    @NotBlank
    private String descricao;

    @NotNull
    @PositiveOrZero
    private Double preco;

    public Produto() {
    }

    public Produto(ProdutoDto produtoDto){
        this.nome = produtoDto.nome();
        this.quantidade = produtoDto.quantidade();
        this.descricao = produtoDto.descricao();
        this.preco = produtoDto.preco();
    }
}
