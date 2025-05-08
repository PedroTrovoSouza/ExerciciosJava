package com.br.locadora.Locadora.dto;

import jakarta.validation.constraints.NotBlank;

public record TesteLocacoDto(@NotBlank String cliente,
                             @NotBlank String filme) {
}
