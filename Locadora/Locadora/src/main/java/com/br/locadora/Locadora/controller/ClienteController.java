package com.br.locadora.Locadora.controller;

import com.br.locadora.Locadora.entity.Cliente;
import com.br.locadora.Locadora.repository.LocadoraRepository;
import com.br.locadora.Locadora.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    private ClienteService service;

    @PutMapping
    public void atualizarFilme() {

    }

    @GetMapping
    public void listarLocalizacoes() {

    }

    @GetMapping
    public void listarFilmes() {

    }

    @GetMapping
    public void listarClientes() {

    }
}
