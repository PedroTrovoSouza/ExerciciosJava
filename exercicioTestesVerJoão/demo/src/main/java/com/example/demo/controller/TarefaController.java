package com.example.demo.controller;

import com.example.demo.dto.TarefaRequestDTO;
import com.example.demo.dto.TarefaResponseDTO;
import com.example.demo.service.TarefaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/tarefa")
public class TarefaController {

    @Autowired
    private TarefaService service;

    @PostMapping
    public ResponseEntity<TarefaResponseDTO> cadastrar(@RequestBody TarefaRequestDTO tarefa) {
        return ResponseEntity.status(201).body(service.salvar(tarefa));
    }

    @GetMapping
    public ResponseEntity<List<TarefaResponseDTO>> listarTodos() {
        List<TarefaResponseDTO> buscarTarefas = service.listarTodasTarefas();

        if (buscarTarefas.isEmpty()) {
            return ResponseEntity.status(204).build();
        }

        return ResponseEntity.status(200).body(buscarTarefas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TarefaResponseDTO> listarPorId(@PathVariable Long id) {
        TarefaResponseDTO buscarTarefaPorId = service.listarTarefaPorId(id);

        if(buscarTarefaPorId == null) {
            return ResponseEntity.status(404).build();
        }
        return ResponseEntity.status(200).body(buscarTarefaPorId);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TarefaResponseDTO> atualizar(
            @PathVariable Long id,
            @RequestBody TarefaRequestDTO dto) {
        TarefaResponseDTO atualizada = service.atualizarTarefa(id, dto);
        return ResponseEntity.ok(atualizada);
    }

    @DeleteMapping("/{id}")
    public  ResponseEntity<Void> deletarPorId(@PathVariable Long id) {
        boolean deletou = service.deletarPorId(id);

        if (deletou) {
            return ResponseEntity.status(204).build();
        } else {
            return ResponseEntity.status(404).build();
        }
    }
}
