package com.br.locadora.Locadora.services;

import com.br.locadora.Locadora.repository.LocadoraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {

    @Autowired
    private LocadoraRepository locadoraRepository;

    
}
