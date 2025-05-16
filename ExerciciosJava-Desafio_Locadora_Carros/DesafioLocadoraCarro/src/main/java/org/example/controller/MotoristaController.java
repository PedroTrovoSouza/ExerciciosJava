package org.example.controller;

import org.example.DTO.MotoristaRequestDTO;
import org.example.DTO.MotoristaResponseDTO;
import org.example.service.MotoristaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/motorista")
public class MotoristaController {

    @Autowired
    private MotoristaService service;

    @PostMapping
    public ResponseEntity<MotoristaResponseDTO> cadastrar(@RequestBody MotoristaRequestDTO dto) {
        MotoristaResponseDTO response = service.cadastrarMotorista(dto);
        return ResponseEntity.status(201).body(response);
    }

    @GetMapping
    public ResponseEntity<List<MotoristaResponseDTO>> listarTodos() {
        List<MotoristaResponseDTO> buscarMotoristas = service.listarTodosMotoristas();

        if (buscarMotoristas.isEmpty()) {
            return ResponseEntity.status(204).build();
        }

        return ResponseEntity.status(200).body(buscarMotoristas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MotoristaResponseDTO> listarPorId(@PathVariable Long id) {
        MotoristaResponseDTO buscarMotoristaPorId = service.listarMotoristaPorId(id);

        if (buscarMotoristaPorId == null) {
            return ResponseEntity.status(404).build();
        }
        return ResponseEntity.status(200).body(buscarMotoristaPorId);
    }
}
