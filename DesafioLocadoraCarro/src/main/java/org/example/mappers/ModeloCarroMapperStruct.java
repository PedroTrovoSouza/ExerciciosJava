package org.example.mappers;

import org.example.DTO.ListagemModeloCarroDTO;
import org.example.DTO.ModeloCarroDTO;
import org.example.entity.ModeloCarro;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ModeloCarroMapperStruct {
    ModeloCarro toEntity(ModeloCarroDTO modeloCarroDTO);
    ModeloCarroDTO toModeloCarroDTO(ModeloCarro entity);
    ListagemModeloCarroDTO toResponseListModeloCarroDTO(ModeloCarro entity);
}
