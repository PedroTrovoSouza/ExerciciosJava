package com.example.demo.service;

import com.example.demo.dto.TarefaRequestDTO;
import com.example.demo.dto.TarefaResponseDTO;
import com.example.demo.entity.Tarefa;
import com.example.demo.exception.TarefaInvalidaException;
import com.example.demo.mapper.TaskMapper;
import com.example.demo.repository.TarefaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TarefaService {

    @Autowired
    private TarefaRepository repository;

    @Autowired
    private TaskMapper mapper;

    public List<TarefaResponseDTO> listarTodasTarefas() {
        List<Tarefa> tarefas = repository.findAll();

        return tarefas.stream()
                .map(mapper::toDTO)
                .toList();
    }

    public TarefaResponseDTO salvar (TarefaRequestDTO dto) {
        if (dto == null || dto.getNome().isBlank()) {
            throw new TarefaInvalidaException("Impossível seguir com cadastro, dados inválidos");
        }

        Tarefa tarefa = mapper.toEntity(dto);
        Tarefa salva = repository.save(tarefa);
        return mapper.toDTO(salva);
    }

    public String deletarPorNome (String nome) {
        if (nome == null || nome.isBlank() || nome.isEmpty()) {
            throw new TarefaInvalidaException("Nome inválido.");
        }
        Optional<Tarefa> tarefaDeletar = repository.findByNomeEqualsIgnoreCase(nome);

        if (tarefaDeletar.isPresent()) {
            repository.deleteByNomeEqualsIgnoreCase(nome);
            return "Tarefa removida: %s".formatted(tarefaDeletar.get().getNome());
        }
        return " ";
    }
}
