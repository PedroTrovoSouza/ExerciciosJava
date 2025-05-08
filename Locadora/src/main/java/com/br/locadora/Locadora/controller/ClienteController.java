package com.br.locadora.Locadora.controller;

import com.br.locadora.Locadora.dto.ClienteDto;
import com.br.locadora.Locadora.entity.Cliente;
import com.br.locadora.Locadora.entity.Filme;
import com.br.locadora.Locadora.entity.Locacao;
import com.br.locadora.Locadora.services.ClienteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @PostMapping
    public ResponseEntity<ClienteDto> postCliente(@RequestBody @Valid ClienteDto novoCliente){
        ClienteDto clienteDto = clienteService.postCliente(novoCliente);

        return ResponseEntity.status(201).body(clienteDto   );
    }

    @PutMapping("/filmes")
    public ResponseEntity<?> atualizarFilme(@RequestBody Filme filme) {
        boolean atualizado = clienteService.atualizarFilme(filme);
        if (atualizado) {
            return ResponseEntity.ok("Filme atualizado com sucesso.");
        }
        return ResponseEntity.badRequest().body("Filme não encontrado.");
    }

    @GetMapping("/filmes")
    public List<Filme> listarFilmes() {
        return clienteService.listarFilmes();
    }

    @GetMapping("/listarClientes")
    public List<Cliente> listarClientes() {
        return clienteService.listarClientes();
    }
}
