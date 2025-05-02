package com.exercicio1.exerciciosSpring.Dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;

public record ProdutoDto(
        @NotBlank String nome,
        @NotNull @PositiveOrZero int quantidade,
        @NotBlank String descricao,
        @NotNull @PositiveOrZero Double preco
) {

}
