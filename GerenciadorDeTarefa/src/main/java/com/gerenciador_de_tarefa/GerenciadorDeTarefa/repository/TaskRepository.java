package com.gerenciador_de_tarefa.GerenciadorDeTarefa.repository;

import com.gerenciador_de_tarefa.GerenciadorDeTarefa.dto.TaskDTO;
import com.gerenciador_de_tarefa.GerenciadorDeTarefa.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {

}
