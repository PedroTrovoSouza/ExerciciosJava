package com.br.locadora.Locadora.controller;

import com.br.locadora.Locadora.dto.TesteLocacoDto;
import com.br.locadora.Locadora.entity.Locacao;
import com.br.locadora.Locadora.services.LocacaoService;
import jakarta.validation.Valid;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/locacoes")
public class locacaoController {

    @Autowired
    private LocacaoService locacaoService;

    @PostMapping
    public ResponseEntity cadastrarLocacao(@RequestBody @Valid TesteLocacoDto dto) {
        try {
            locacaoService.postLocacao(dto);
            return ResponseEntity.status(201).body(dto);
        } catch (RuntimeException e) {
            return ResponseEntity.status(409).body(e.getMessage());
        }
    }

    @PatchMapping("/{id}")
    public ResponseEntity devolverFilme(@PathVariable long id){
        try {
            return ResponseEntity.status(200).body(locacaoService.devolverFilme(id, LocalDate.now()));
        } catch (RuntimeException e) {
            return ResponseEntity.status(404).build();
        }
    }

    @GetMapping()
    public List<Locacao> listarLocalizacoes() {
        return locacaoService.listarLocacoes();
    }

}
