package com.desafio_locadora.dto;

import com.desafio_locadora.entity.Fabricante;
import com.desafio_locadora.tipos.Categoria;

public record ListagemModeloCarroDTO(
        String descricao,
        Fabricante fabricante,
        Categoria categoria
) {
}
