package org.example.DTO;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.entity.Aluguel;

import java.math.BigDecimal;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AluguelResponseDTO {
    private Long id;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date dataPedido;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date dataEntrega;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date dataDevolucao;

    private BigDecimal valorTotal;

    private MotoristaResponseDTO motorista;

    public AluguelResponseDTO(Aluguel aluguel) {
        this.id = aluguel.getId();
        this.dataPedido = aluguel.getDataPedido().getTime();
        this.dataEntrega = aluguel.getDataEntrega();
        this.dataDevolucao = aluguel.getDataDevolucao();
        this.valorTotal = aluguel.getValorTotal();

        if (aluguel.getMotorista() != null) {
            this.motorista = new MotoristaResponseDTO(aluguel.getMotorista());
        }
    }
}
