package org.example.DTO;

import org.example.entity.Fabricante;
import org.example.enums.Categoria;

public record ListagemModeloCarroDTO(
        String descricao,
        Fabricante fabricante,
        Categoria categoria
) {
}
