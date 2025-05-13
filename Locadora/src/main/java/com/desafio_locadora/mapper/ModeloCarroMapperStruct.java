package com.desafio_locadora.mapper;
import com.desafio_locadora.dto.CarroDTO;
import com.desafio_locadora.dto.ListagemCarroDTO;
import com.desafio_locadora.dto.ListagemModeloCarroDTO;
import com.desafio_locadora.dto.ModeloCarroDTO;
import com.desafio_locadora.entity.Carro;
import com.desafio_locadora.entity.ModeloCarro;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ModeloCarroMapperStruct {
    ModeloCarro toEntity(ModeloCarroDTO modeloCarroDTO);
    ModeloCarroDTO toModeloCarroDTO(ModeloCarro entity);
    ListagemModeloCarroDTO toResponseListModeloCarroDTO(ModeloCarro entity);
}
