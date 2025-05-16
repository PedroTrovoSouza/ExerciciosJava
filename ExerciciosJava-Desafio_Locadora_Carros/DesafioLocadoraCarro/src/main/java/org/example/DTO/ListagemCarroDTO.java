package org.example.DTO;

import org.example.entity.Acessorio;
import org.example.entity.Fabricante;
import org.example.entity.ModeloCarro;
import org.example.enums.Categoria;

import java.math.BigDecimal;
import java.util.List;

public record ListagemCarroDTO(
        Fabricante fabricante,
        ModeloCarro modeloCarro,
        Categoria categoria,
        List<Acessorio> acessorio,
        BigDecimal valorDiaria
) {
}
