package com.desafio_locadora.service;

import com.desafio_locadora.dto.ListagemCarroDTO;
import com.desafio_locadora.entity.Acessorio;
import com.desafio_locadora.entity.Carro;
import com.desafio_locadora.entity.ModeloCarro;
import com.desafio_locadora.mapper.CarroMapperStruct;
import com.desafio_locadora.repository.AcessorioRepository;
import com.desafio_locadora.repository.CarroRepository;
import com.desafio_locadora.repository.ModeloCarroRepository;
import com.desafio_locadora.tipos.Categoria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Service;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class CarroService {

    @Autowired
    CarroRepository carroRepository;

    @Autowired
    ModeloCarroRepository modeloCarroRepository;

    @Autowired
    AcessorioRepository acessorioRepository;

    @Autowired
    private CarroMapperStruct carroMapper;

    public List<ListagemCarroDTO> getAll(){
        List<Carro> listaCarro = carroRepository.findAll();

        if(listaCarro.isEmpty()){
            throw new RuntimeException("Nenhum carro encontrado!!");
        }

        List<ListagemCarroDTO> listagemCarros = new ArrayList<ListagemCarroDTO>();

                listaCarro.forEach(c ->{
            listagemCarros.add(carroMapper.toResponseListCarroDTO(c));
        });
        return listagemCarros;
    }

    public List<ModeloCarro> getByCategoria(Categoria categoria) {
        List<ModeloCarro> modelos = modeloCarroRepository.findByCategoria(categoria);

        if (modelos == null || modelos.isEmpty()) {
            throw new RuntimeException("Nenhum modelo com essa categoria foi encontrado");
        }

        return modelos;
    }

    public List<Carro> buscarCarrosPorDescricaoAcessorio(String descricaoAcessorio) {
        List<Carro> carros = carroRepository.findByAcessorioDescricao(descricaoAcessorio);

        if (carros.isEmpty()) {
            throw new RuntimeException("Nenhum carro encontrado com o acessório de descrição: " + descricaoAcessorio);
        }

        return carros;
    }


}
