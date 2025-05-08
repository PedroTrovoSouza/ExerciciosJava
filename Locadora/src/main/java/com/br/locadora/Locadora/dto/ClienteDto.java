package com.br.locadora.Locadora.dto;

import jakarta.validation.constraints.NotBlank;

public record ClienteDto(
        @NotBlank String nome,
        @NotBlank String email
) {
}
