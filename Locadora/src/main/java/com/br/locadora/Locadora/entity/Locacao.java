package com.br.locadora.Locadora.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
public class Locacao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    private Cliente cliente;

    @ManyToOne
    private Filme filme;

    @NotNull
    LocalDate dataLocacao;

    LocalDate dataDevolucao;

    @NotNull
    private Boolean devolvido = false;

    public Locacao(){

    }

    public Locacao(Cliente cliente, Filme filme) {
        this.cliente = cliente;
        this.filme = filme;
        this.dataLocacao = LocalDate.now();
    }
}
