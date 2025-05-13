package com.example.demo.mapper;

import com.example.demo.dto.TarefaRequestDTO;
import com.example.demo.dto.TarefaResponseDTO;
import com.example.demo.entity.Tarefa;
import org.springframework.stereotype.Component;

@Component
public class TaskMapper {

    public Tarefa toEntity(TarefaRequestDTO dto) {
        Tarefa tarefa = new Tarefa();
        tarefa.setNome(dto.getNome());
        return tarefa;
    }

    public TarefaResponseDTO toDTO(Tarefa tarefa) {
        TarefaResponseDTO dto = new TarefaResponseDTO();
        dto.setNome(tarefa.getNome());
        return dto;
    }
}
