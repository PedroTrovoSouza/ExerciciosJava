package com.br.locadora.Locadora.services;

import com.br.locadora.Locadora.entity.Cliente;
import com.br.locadora.Locadora.entity.Filme;
import com.br.locadora.Locadora.entity.Locacao;
import com.br.locadora.Locadora.repository.ClienteRepository;
import com.br.locadora.Locadora.repository.FilmeRepository;
import com.br.locadora.Locadora.repository.LocadoraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private LocadoraRepository locadoraRepository;

    @Autowired
    private FilmeRepository filmeRepository;

    public List<Cliente> listarClientes() {
        return clienteRepository.findAll();
    }

    public List<Locacao> listarLocacoes() {
        return locadoraRepository.findAll();
    }

    public List<Filme> listarFilmes() {
        return filmeRepository.findAll();
    }

    public boolean atualizarFilme(Filme filmeAtualizado) {
        Optional<Filme> opt = filmeRepository.findById(filmeAtualizado.getId());
        if (opt.isPresent()) {
            Filme filme = opt.get();
            filme.setTitulo(filmeAtualizado.getTitulo());
            filme.setGenero(filmeAtualizado.getGenero());
            filme.setDiretor(filmeAtualizado.getDiretor());
            filmeRepository.save(filme);
            return true;
        }
        return false;
    }
}