package org.example.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Aluguel{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Calendar dataPedido;
    private Date dataEntrega;

    private Date dataDevolucao;
    private BigDecimal valorTotal;

    private Boolean carrinho;

    @OneToOne
    @JoinColumn(name = "apolice_id")
    private ApoliceSeguro apolice;

    @ManyToOne
    @JoinColumn(name = "motorista_id")
    private Motorista motorista;

    @ManyToOne
    @JoinColumn(name = "carro_id")
    private Carro carro;
}
