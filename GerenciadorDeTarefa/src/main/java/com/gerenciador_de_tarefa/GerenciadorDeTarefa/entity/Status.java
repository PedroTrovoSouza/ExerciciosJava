package com.gerenciador_de_tarefa.GerenciadorDeTarefa.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public enum Status {
    PENDENTE,
    EM_ANDAMENTO,
    CONCLUIDA
}
