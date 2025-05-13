package org.example.DTO;

import org.example.entity.Fabricante;
import org.example.enums.Categoria;

import java.math.BigDecimal;

public record ModeloCarroDTO(
        String descricao,
        Fabricante fabricante,
        Categoria categoria
) {
}
