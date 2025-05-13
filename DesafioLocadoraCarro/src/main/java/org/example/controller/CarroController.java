package org.example.controller;

import org.example.DTO.ListagemCarroDTO;
import org.example.entity.Carro;
import org.example.entity.ModeloCarro;
import org.example.enums.Categoria;
import org.example.service.CarroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/carro")
public class CarroController {

    @Autowired
    CarroService carroService;

    @GetMapping
    public ResponseEntity<?> getAllCarros() {
        try {
            return ResponseEntity.status(200).body(carroService.getAll());
        } catch (RuntimeException e) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(e.getMessage());
        }
    }

    @GetMapping("/categoria/{categoria}")
    public ResponseEntity<?> getByCategoria(@PathVariable Categoria categoria) {
        try {
            List<ModeloCarro> carrosEncontrados = carroService.getByCategoria(categoria);
            return ResponseEntity.status(200).body(carrosEncontrados);
        } catch (RuntimeException e) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(e.getMessage());
        }

    }

    @GetMapping("/acessorio/descricao/{descricaoAcessorio}")
    public ResponseEntity<?> buscarCarrosPorDescricaoAcessorio(@PathVariable String descricaoAcessorio) {
        try {
            List<Carro> carros = carroService.buscarCarrosPorDescricaoAcessorio(descricaoAcessorio);
            return ResponseEntity.ok(carros);
        } catch (RuntimeException e) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(e.getMessage());
        }
    }

    @GetMapping("/disponiveis")
    public ResponseEntity<?> buscarCarrosDisponives() {
        try {
            List<Carro> carros = carroService.buscarCarroDisponivel();
            return ResponseEntity.ok(carros);
        } catch (RuntimeException e) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(e.getMessage());
        }
    }
}
