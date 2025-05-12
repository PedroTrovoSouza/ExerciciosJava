package com.desafio_locadora.dto;

import com.desafio_locadora.entity.Fabricante;
import com.desafio_locadora.tipos.Categoria;

import java.math.BigDecimal;

public record ModeloCarroDTO(
        String descricao,
        Fabricante fabricante,
        Categoria categoria
) {
}
