package com.br.locadora.Locadora.controller;

import com.br.locadora.Locadora.dto.FilmeDto;
import com.br.locadora.Locadora.services.FilmeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/filmes")
public class FilmeController {

    @Autowired
    FilmeService filmeService;

    @PostMapping
    public ResponseEntity<FilmeDto> postFilme(@RequestBody @Valid FilmeDto novoFilme){
        FilmeDto filmeDto = filmeService.postFilme(novoFilme);

        return ResponseEntity.status(201).body(filmeDto);
    }
}
