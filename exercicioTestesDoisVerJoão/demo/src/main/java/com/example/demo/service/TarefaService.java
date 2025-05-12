package com.example.demo.service;

import com.example.demo.dto.TarefaRequestDTO;
import com.example.demo.dto.TarefaResponseDTO;
import com.example.demo.entity.Tarefa;
import com.example.demo.exception.TarefaInvalidaException;
import com.example.demo.mapper.TarefaMapper;
import com.example.demo.repository.TarefaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
public class TarefaService {

    @Autowired
    private TarefaRepository repository;

    @Autowired
    private TarefaMapper mapper;

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
            throw new TarefaInvalidaException("ID inválido.");
        }
        Optional<Tarefa> tarefaDeletar = repository.findTarefaByNomeEqualsIgnoreCase(nome);

        if (tarefaDeletar.isPresent()) {
            repository.deleteById(tarefaDeletar.get().getId());
            return "Tarefa removida: %s".formatted(tarefaDeletar.get().getNome());
        }
        return " ";
    }
}
