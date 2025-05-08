package com.br.locadora.Locadora.entity;

import com.br.locadora.Locadora.dto.ClienteDto;
import com.br.locadora.Locadora.dto.FilmeDto;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Filme {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull
    private String titulo;

    @NotNull
    private String genero;

    @NotNull
    private String diretor;

    public Filme(FilmeDto filmeDto){
        this.titulo = filmeDto.titulo();
        this.genero = filmeDto.genero();
        this.diretor = filmeDto.diretor();
    }
}
