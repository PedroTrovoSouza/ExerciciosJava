package org.example.mappers;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.example.DTO.CarroDTO;
import org.example.DTO.ListagemCarroDTO;
import org.example.entity.Acessorio;
import org.example.entity.Carro;
import org.example.entity.Fabricante;
import org.example.entity.ModeloCarro;
import org.example.enums.Categoria;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-05-13T11:03:09-0300",
    comments = "version: 1.6.3, compiler: javac, environment: Java 24 (Oracle Corporation)"
)
@Component
public class CarroMapperStructImpl implements CarroMapperStruct {

    @Override
    public Carro toEntity(CarroDTO carroDTO) {
        if ( carroDTO == null ) {
            return null;
        }

        Carro carro = new Carro();

        carro.setPlaca( carroDTO.placa() );
        carro.setChassi( carroDTO.chassi() );
        carro.setCor( carroDTO.cor() );
        carro.setValorDiaria( carroDTO.valorDiaria() );

        return carro;
    }

    @Override
    public CarroDTO toCarroDTO(Carro entity) {
        if ( entity == null ) {
            return null;
        }

        String placa = null;
        String chassi = null;
        String cor = null;
        BigDecimal valorDiaria = null;

        placa = entity.getPlaca();
        chassi = entity.getChassi();
        cor = entity.getCor();
        valorDiaria = entity.getValorDiaria();

        CarroDTO carroDTO = new CarroDTO( placa, chassi, cor, valorDiaria );

        return carroDTO;
    }

    @Override
    public ListagemCarroDTO toResponseListCarroDTO(Carro entity) {
        if ( entity == null ) {
            return null;
        }

        ModeloCarro modeloCarro = null;
        List<Acessorio> acessorio = null;
        BigDecimal valorDiaria = null;

        modeloCarro = entity.getModeloCarro();
        List<Acessorio> list = entity.getAcessorio();
        if ( list != null ) {
            acessorio = new ArrayList<Acessorio>( list );
        }
        valorDiaria = entity.getValorDiaria();

        Fabricante fabricante = null;
        Categoria categoria = null;

        ListagemCarroDTO listagemCarroDTO = new ListagemCarroDTO( fabricante, modeloCarro, categoria, acessorio, valorDiaria );

        return listagemCarroDTO;
    }
}
