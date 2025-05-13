package com.desafio_locadora.dto;

import com.desafio_locadora.entity.Acessorio;
import com.desafio_locadora.entity.Fabricante;
import com.desafio_locadora.entity.ModeloCarro;
import com.desafio_locadora.tipos.Categoria;

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
