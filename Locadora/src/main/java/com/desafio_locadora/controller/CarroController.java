package com.desafio_locadora.controller;

import com.desafio_locadora.dto.CarroDTO;
import com.desafio_locadora.dto.ListagemCarroDTO;
import com.desafio_locadora.entity.Acessorio;
import com.desafio_locadora.entity.Carro;
import com.desafio_locadora.entity.ModeloCarro;
import com.desafio_locadora.service.CarroService;
import com.desafio_locadora.tipos.Categoria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/carro")
public class CarroController {

    @Autowired
    CarroService carroService;

    @GetMapping
    public ResponseEntity<List<ListagemCarroDTO>> getAllCarros(){
        return ResponseEntity.status(200).body(carroService.getAll());
    }

    @GetMapping("/categoria/{categoria}")
    public ResponseEntity<List<ModeloCarro>> getByCategoria(@PathVariable Categoria categoria){
        List<ModeloCarro> carrosEncontrados = carroService.getByCategoria(categoria);

        return ResponseEntity.status(200).body(carrosEncontrados);
    }

    @GetMapping("/acessorio/descricao/{descricaoAcessorio}")
    public ResponseEntity<List<Carro>> buscarCarrosPorDescricaoAcessorio(@PathVariable String descricaoAcessorio) {
        List<Carro> carros = carroService.buscarCarrosPorDescricaoAcessorio(descricaoAcessorio);
        return ResponseEntity.ok(carros);
    }
}
