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

    @GetMapping
    public ResponseEntity<List<TarefaResponseDTO>> listarTodos() {
        List<TarefaResponseDTO> buscarTarefas = service.listarTodasTarefas();

        if (buscarTarefas.isEmpty()) {
            return ResponseEntity.status(204).build();
        }

        return ResponseEntity.status(200).body(buscarTarefas);
    }

    @PostMapping
    public ResponseEntity<TarefaResponseDTO> cadastrar(@RequestBody TarefaRequestDTO tarefa) {
        return ResponseEntity.status(201).body(service.salvar(tarefa));
    }

    @DeleteMapping("/{nome}")
    public  ResponseEntity<String> deletarPorId(@PathVariable String nome) {
        String deletou = service.deletarPorNome(nome);

        if (deletou.isBlank()) {
            return ResponseEntity.status(404).build();
        } else {
            return ResponseEntity.status(200).body(deletou);
        }
    }
}
