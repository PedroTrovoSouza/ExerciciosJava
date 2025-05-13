package org.example.DTO;

import java.math.BigDecimal;

public record CarroDTO(
        String placa,
        String chassi,
        String cor,
        BigDecimal valorDiaria
) {
}
