package org.example.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.antlr.v4.runtime.misc.NotNull;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AluguelRequestDTO {
    @NotNull
    private Calendar dataPedido;

    @NotNull
    private Date dataEntrega;

    @NotNull
    private Date dataDevolucao;

    @NotNull
    private BigDecimal valorTotal;

    @NotNull
    private Long apoliceId;

    @NotNull
    private Long motoristaId;

    @NotNull
    private Long carroId;
}
