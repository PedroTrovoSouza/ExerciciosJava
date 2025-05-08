package com.br.locadora.Locadora.services;

import com.br.locadora.Locadora.dto.FilmeDto;
import com.br.locadora.Locadora.entity.Filme;
import com.br.locadora.Locadora.repository.FilmeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FilmeService {

    @Autowired
    private FilmeRepository filmeRepository;

    public FilmeDto postFilme(FilmeDto novoFilme){
        filmeRepository.save(new Filme(novoFilme));
        return novoFilme;
    }
}
