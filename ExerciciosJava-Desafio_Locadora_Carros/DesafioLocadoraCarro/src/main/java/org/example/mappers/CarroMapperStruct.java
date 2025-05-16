package org.example.mappers;

import org.example.DTO.CarroDTO;
import org.example.DTO.ListagemCarroDTO;
import org.example.entity.Carro;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CarroMapperStruct {
    Carro toEntity(CarroDTO carroDTO);
    CarroDTO toCarroDTO(Carro entity);
    ListagemCarroDTO toResponseListCarroDTO(Carro entity);
}
