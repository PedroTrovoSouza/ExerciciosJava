package com.gerenciador_de_tarefa.GerenciadorDeTarefa.entity;

import com.gerenciador_de_tarefa.GerenciadorDeTarefa.dto.TaskDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.antlr.v4.runtime.misc.NotNull;

import java.util.Optional;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull
    private String title;

    @NotNull
    private String description;

    @Enumerated(EnumType.STRING)
    private Status status;

    public Task(TaskDTO dto) {
        this.title = dto.title();
        this.description =  dto.description();
        this.status =  dto.status();
    }
}
