package com.br.locadora.Locadora.dto;

import jakarta.validation.constraints.NotBlank;
import org.aspectj.weaver.ast.Not;

public record FilmeDto(
        @NotBlank String titulo,
        @NotBlank String genero,
        @NotBlank String diretor
) {
}
