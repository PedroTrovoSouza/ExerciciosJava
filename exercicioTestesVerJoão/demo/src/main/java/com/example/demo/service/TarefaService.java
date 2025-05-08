package com.example.demo.service;

import com.example.demo.dto.TarefaRequestDTO;
import com.example.demo.dto.TarefaResponseDTO;
import com.example.demo.entity.Tarefa;
import com.example.demo.exception.TarefaInvalidaException;
import com.example.demo.mapper.TarefaMapper;
import com.example.demo.repository.TarefaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TarefaService {

    @Autowired
    private TarefaRepository repository;

    @Autowired
    private TarefaMapper mapper;

    public TarefaResponseDTO salvar (TarefaRequestDTO dto) {
        if (dto == null || dto.getNome().isBlank() || dto.getDescricao().isBlank()) {
            throw new TarefaInvalidaException("Impossível seguir com cadastro, dados inválidos");
        }

        Tarefa tarefa = mapper.toEntity(dto); // Converte DTO para entidade
        Tarefa salva = repository.save(tarefa);
        return mapper.toDTO(salva);
    }

    public List<TarefaResponseDTO> listarTodasTarefas() {
        List<Tarefa> tarefas = repository.findAll();

        return tarefas.stream()
                .map(mapper::toDTO)
                .toList();
    }

    public TarefaResponseDTO listarTarefaPorId(Long id) {
        if (id == null || id <= 0) {
            throw new TarefaInvalidaException("ID inválido.");
        }

//        Quando o metodo retornar uma entidade é possível fazer como esta abaixo:
//        repository.findById(id).orElseThrow();

        Tarefa tarefa = repository.findById(id)
                .orElseThrow(() -> new TarefaInvalidaException("Tarefa não encontrada."));

        return mapper.toDTO(tarefa);
    }

    public TarefaResponseDTO atualizarTarefa(Long id, TarefaRequestDTO dto) {
        if (id == null || id <= 0) {
            throw new TarefaInvalidaException("ID inválido.");
        }
        Tarefa existente = repository.findById(id)
                .orElseThrow(() -> new TarefaInvalidaException("Tarefa não encontrada."));

        existente.setNome(dto.getNome());
        existente.setDescricao(dto.getDescricao());
        existente.setStatus(dto.getStatus());

        Tarefa salva = repository.save(existente);
        return mapper.toDTO(salva);
    }

    public boolean deletarPorId (Long id) {
        if (id == null || id <= 0) {
            throw new TarefaInvalidaException("ID inválido.");
        }
        boolean existe = repository.existsById(id);
        if (!existe) {
            return false;
        }

        repository.deleteById(id);
        return true;
    }
}
