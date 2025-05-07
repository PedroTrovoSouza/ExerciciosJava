package com.gerenciador_de_tarefa.GerenciadorDeTarefa.dto;

import com.gerenciador_de_tarefa.GerenciadorDeTarefa.entity.Status;
import org.antlr.v4.runtime.misc.NotNull;

public record TaskDTO(
        @NotNull String title,
        @NotNull  String description,
        @NotNull Status status
        ) {
}
