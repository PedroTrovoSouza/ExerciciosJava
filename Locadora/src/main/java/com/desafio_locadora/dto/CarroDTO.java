package com.desafio_locadora.dto;

import java.math.BigDecimal;

public record CarroDTO(
        String placa,
        String chassi,
        String cor,
        BigDecimal valorDiaria
) {
}
