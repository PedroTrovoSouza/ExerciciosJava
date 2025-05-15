package org.example.service;

import org.example.DTO.ListagemCarroDTO;
import org.example.entity.Carro;
import org.example.entity.ModeloCarro;
import org.example.enums.Categoria;
import org.example.mappers.CarroMapperStruct;
import org.example.repository.AcessorioRepository;
import org.example.repository.CarroRepository;
import org.example.repository.ModeloCarroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Date;
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

    public List<Carro> buscarCarroDisponivel(){
        List<Carro> carros = carroRepository.findCarrosDisponiveis();

        if(carros.isEmpty()){
            throw new RuntimeException("Nenhum carro disponivel");
        }

        return carros;
    }

}
