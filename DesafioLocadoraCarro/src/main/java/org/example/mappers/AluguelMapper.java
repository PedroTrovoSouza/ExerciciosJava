package org.example.mappers;

import org.example.DTO.AluguelRequestDTO;
import org.example.DTO.AluguelResponseDTO;
import org.example.entity.Aluguel;
import org.example.repository.ApoliceSeguroRepository;
import org.example.repository.MotoristaRepository;

public class AluguelMapper {

    private final ApoliceSeguroRepository apoliceRepository;
    private final MotoristaRepository motoristaRepository;

    public AluguelMapper(ApoliceSeguroRepository apoliceRepository,
                         MotoristaRepository motoristaRepository) {
        this.apoliceRepository = apoliceRepository;
        this.motoristaRepository = motoristaRepository;
    }

    public Aluguel toEntity(AluguelRequestDTO dto) {
        Aluguel aluguel = new Aluguel();
        aluguel.setDataPedido(dto.getDataPedido());
        aluguel.setDataEntrega(dto.getDataEntrega());
        aluguel.setDataDevolucao(dto.getDataDevolucao());
        aluguel.setValorTotal(dto.getValorTotal());

        if (dto.getApoliceId() != null) {
            aluguel.setApolice(apoliceRepository.findById(dto.getApoliceId()).orElse(null));
        }

        if (dto.getMotoristaId() != null) {
            aluguel.setMotorista(motoristaRepository.findById(dto.getMotoristaId()).orElse(null));
        }

        return aluguel;
    }

    // incompleto
    public AluguelResponseDTO toDTO(Aluguel aluguel) {
        AluguelResponseDTO dto = new AluguelResponseDTO();
        dto.setDataPedido(aluguel.getDataPedido());
        dto.setDataEntrega(aluguel.getDataEntrega());
        dto.setDataDevolucao(aluguel.getDataDevolucao());
        aluguel.setValorTotal(aluguel.getValorTotal());

        return dto;
    }
}
