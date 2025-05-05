package com.br.locadora.Locadora.entity;

import com.br.locadora.Locadora.dto.ClienteDto;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import java.util.List;
import java.util.ArrayList;

@Entity
@Getter
@Setter
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull
    private String nome;

    @NotNull
    private String email;

    public Cliente() {
    }

    public Cliente(ClienteDto clienteDto){
        this.nome = clienteDto.nome();
        this.email = clienteDto.email();
    }

}
