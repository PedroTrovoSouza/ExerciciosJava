package com.desafio_locadora.entity;

import com.desafio_locadora.dto.CarroDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Carro {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id_carro;

    private String placa;
    private String chassi;
    private String cor;
    private BigDecimal valorDiaria;

    @ManyToOne
    ModeloCarro modeloCarro;

    @ManyToMany
    @JoinTable(name = "carro_acessorio",
            joinColumns = @JoinColumn(name = "id_carro"),
            inverseJoinColumns = @JoinColumn(name = "id_acessorio"))
    List<Acessorio> acessorio;
}
