package org.example.controller;

import org.example.DTO.AluguelRequestDTO;
import org.example.DTO.AluguelResponseDTO;
import org.example.entity.Aluguel;
import org.example.service.AluguelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/aluguel")
public class AluguelController {

    @Autowired
    private AluguelService service;

    @PostMapping
    public ResponseEntity<AluguelResponseDTO> cadastrar(@RequestBody AluguelRequestDTO dto) {
        AluguelResponseDTO response = service.cadastrarAluguel(dto);
        return ResponseEntity.status(201).body(response);
    }

    @GetMapping
    public ResponseEntity<List<AluguelResponseDTO>> listarTodos() {
        List<AluguelResponseDTO> alugueis = service.listarTodosAlugueis();

        if (alugueis.isEmpty()) {
            return ResponseEntity.status(204).build();
        }

        return ResponseEntity.status(200).body(alugueis);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AluguelResponseDTO> listarPorId (@PathVariable Long id) {
        AluguelResponseDTO aluguelPorId = service.listarAluguelPorId(id);

        if (aluguelPorId == null) {
            return ResponseEntity.status(404).build();
        }
        return ResponseEntity.status(200).body(aluguelPorId);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AluguelResponseDTO> atualizarPorId(
            @PathVariable Long id,
            @RequestBody AluguelRequestDTO dto
    ) {
        AluguelResponseDTO atualizado = service.atualizarAluguel(id, dto);
        return ResponseEntity.ok(atualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarPorId(@PathVariable Long id) {
        boolean deletou = service.deletarAluguelPorId(id);
        if(deletou) {
            return ResponseEntity.status(200).build();
        }
        return ResponseEntity.status(204).build();
    }

    @PatchMapping("/{id}")
    public ResponseEntity<AluguelResponseDTO> carrinho(@PathVariable long id){
        try{
            AluguelResponseDTO aluguelAtualizado = service.confirmarAluguel(id);
            return ResponseEntity.status(200).body(aluguelAtualizado);
        }catch (RuntimeException e){
             return ResponseEntity.status(404).build();
        }
    }
}
