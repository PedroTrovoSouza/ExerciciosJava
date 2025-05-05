package com.br.locadora.Locadora.services;

import com.br.locadora.Locadora.dto.TesteLocacoDto;
import com.br.locadora.Locadora.entity.Cliente;
import com.br.locadora.Locadora.entity.Filme;
import com.br.locadora.Locadora.entity.Locacao;
import com.br.locadora.Locadora.repository.ClienteRepository;
import com.br.locadora.Locadora.repository.FilmeRepository;
import com.br.locadora.Locadora.repository.LocacaoRepository;
import org.antlr.v4.runtime.RuntimeMetaData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class LocacaoService {

    @Autowired
    private LocacaoRepository locacaoRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private FilmeRepository filmeRepository;

    public void postLocacao(TesteLocacoDto dto){
        Cliente cliente = clienteRepository.findByNome(dto.cliente());
        Filme filme = filmeRepository.findByTitulo(dto.filme());

        Optional<Locacao> verificarFilme = locacaoRepository.verificarFilmeAlugado(filme.getId());

        if(verificarFilme.isPresent()){
            throw new RuntimeException("Filme já está alugado!!");
        }

        Locacao locacao = new Locacao(cliente, filme);
        locacaoRepository.save(locacao);
    }

    public TesteLocacoDto devolverFilme(long id, LocalDate dataDevolucao){
        Optional<Locacao> locacaoEncontrada = locacaoRepository.findById(id);

        if (locacaoEncontrada.isEmpty()) {
            throw new RuntimeException("Locação não encontrada!");
        }

        locacaoRepository.devolverFilme(id, dataDevolucao);
        return new TesteLocacoDto(locacaoEncontrada.get().getCliente().getNome(), locacaoEncontrada.get().getFilme().getTitulo());
    }

    public List<Locacao> listarLocacoes() {
        return locacaoRepository.findAll();
    }
}
