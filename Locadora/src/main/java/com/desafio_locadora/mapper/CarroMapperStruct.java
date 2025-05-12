package com.desafio_locadora.mapper;
import com.desafio_locadora.dto.CarroDTO;
import com.desafio_locadora.dto.ListagemCarroDTO;
import com.desafio_locadora.entity.Carro;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CarroMapperStruct {
    Carro toEntity(CarroDTO carroDTO);
    CarroDTO toCarroDTO(Carro entity);
    ListagemCarroDTO toResponseListCarroDTO(Carro entity);
}
