package com.exercicio1.exerciciosSpring.Dto;

import jakarta.validation.constraints.NotNull;

public record PrecoDto(
        @NotNull int preco
) {}
