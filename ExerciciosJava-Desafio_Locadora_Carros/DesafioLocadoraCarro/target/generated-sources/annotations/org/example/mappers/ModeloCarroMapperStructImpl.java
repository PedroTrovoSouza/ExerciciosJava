package org.example.mappers;

import javax.annotation.processing.Generated;
import org.example.DTO.ListagemModeloCarroDTO;
import org.example.DTO.ModeloCarroDTO;
import org.example.entity.Fabricante;
import org.example.entity.ModeloCarro;
import org.example.enums.Categoria;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-05-16T08:59:15-0300",
    comments = "version: 1.6.3, compiler: javac, environment: Java 24 (Oracle Corporation)"
)
@Component
public class ModeloCarroMapperStructImpl implements ModeloCarroMapperStruct {

    @Override
    public ModeloCarro toEntity(ModeloCarroDTO modeloCarroDTO) {
        if ( modeloCarroDTO == null ) {
            return null;
        }

        ModeloCarro modeloCarro = new ModeloCarro();

        modeloCarro.setDescricao( modeloCarroDTO.descricao() );
        modeloCarro.setFabricante( modeloCarroDTO.fabricante() );
        modeloCarro.setCategoria( modeloCarroDTO.categoria() );

        return modeloCarro;
    }

    @Override
    public ModeloCarroDTO toModeloCarroDTO(ModeloCarro entity) {
        if ( entity == null ) {
            return null;
        }

        String descricao = null;
        Fabricante fabricante = null;
        Categoria categoria = null;

        descricao = entity.getDescricao();
        fabricante = entity.getFabricante();
        categoria = entity.getCategoria();

        ModeloCarroDTO modeloCarroDTO = new ModeloCarroDTO( descricao, fabricante, categoria );

        return modeloCarroDTO;
    }

    @Override
    public ListagemModeloCarroDTO toResponseListModeloCarroDTO(ModeloCarro entity) {
        if ( entity == null ) {
            return null;
        }

        String descricao = null;
        Fabricante fabricante = null;
        Categoria categoria = null;

        descricao = entity.getDescricao();
        fabricante = entity.getFabricante();
        categoria = entity.getCategoria();

        ListagemModeloCarroDTO listagemModeloCarroDTO = new ListagemModeloCarroDTO( descricao, fabricante, categoria );

        return listagemModeloCarroDTO;
    }
}
