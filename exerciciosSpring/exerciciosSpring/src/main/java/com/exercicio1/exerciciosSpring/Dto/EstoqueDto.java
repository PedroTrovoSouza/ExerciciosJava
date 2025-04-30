package com.exercicio1.exerciciosSpring.Dto;

import jakarta.validation.constraints.NotNull;

public record EstoqueDto(
        @NotNull int quantidade
) {

}
