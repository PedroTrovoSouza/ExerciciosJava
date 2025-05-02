package com.br.locadora.Locadora.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Locacao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    @ManyToOne
    Cliente cliente;

    @OneToMany
    private List<Filme> filme;

    @NotNull
    LocalDate dataLocacao;

    @NotNull
    LocalDate dataDevolucao;

    @NotNull
    private Boolean devolvido = true;

    public Boolean getDevolvido() {
        return devolvido;
    }

    public void setDevolvido(Boolean devolvido) {
        this.devolvido = devolvido;
    }
}
