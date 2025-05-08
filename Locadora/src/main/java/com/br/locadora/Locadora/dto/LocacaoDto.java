package com.br.locadora.Locadora.dto;

import com.br.locadora.Locadora.entity.Cliente;
import com.br.locadora.Locadora.entity.Filme;
import jakarta.validation.constraints.NotBlank;
import org.aspectj.weaver.ast.Not;

import java.time.LocalDate;

public record LocacaoDto(
        @NotBlank String cliente,
        @NotBlank String filme
        ) {
}
