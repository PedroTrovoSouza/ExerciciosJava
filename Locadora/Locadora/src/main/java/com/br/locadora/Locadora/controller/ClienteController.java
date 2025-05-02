package com.br.locadora.Locadora.controller;

import com.br.locadora.Locadora.entity.Cliente;
import com.br.locadora.Locadora.entity.Filme;
import com.br.locadora.Locadora.entity.Locacao;
import com.br.locadora.Locadora.repository.LocadoraRepository;
import com.br.locadora.Locadora.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    private ClienteService service;

    @PutMapping("/filmes")
    public ResponseEntity<?> atualizarFilme(@RequestBody Filme filme) {
        boolean atualizado = service.atualizarFilme(filme);
        if (atualizado) {
            return ResponseEntity.ok("Filme atualizado com sucesso.");
        }
        return ResponseEntity.badRequest().body("Filme não encontrado.");
    }

    @GetMapping("/locacoes")
    public List<Locacao> listarLocalizacoes() {
        return service.listarLocacoes();
    }

    @GetMapping("/filmes")
    public List<Filme> listarFilmes() {
        return service.listarFilmes();
    }

    @GetMapping("/listarClientes")
    public List<Cliente> listarClientes() {
        return service.listarClientes();
    }
}
