package org.example.mappers;

import org.example.DTO.AluguelRequestDTO;
import org.example.DTO.AluguelResponseDTO;
import org.example.entity.Aluguel;
import org.example.repository.MotoristaRepository;
import org.springframework.stereotype.Component;

@Component
public class AluguelMapper {

    private final MotoristaRepository motoristaRepository;

    public AluguelMapper(MotoristaRepository motoristaRepository) {
        this.motoristaRepository = motoristaRepository;
    }

    public Aluguel toEntity(AluguelRequestDTO dto) {
        Aluguel aluguel = new Aluguel();
        aluguel.setDataPedido(dto.getDataPedido());
        aluguel.setDataEntrega(dto.getDataEntrega());
        aluguel.setDataDevolucao(dto.getDataDevolucao());
        aluguel.setValorTotal(dto.getValorTotal());

        if (dto.getMotoristaId() != null) {
            aluguel.setMotorista(motoristaRepository.findById(dto.getMotoristaId()).orElse(null));
        }

        return aluguel;
    }

    public AluguelResponseDTO toDTO(Aluguel aluguel) {
        AluguelResponseDTO dto = new AluguelResponseDTO();
        dto.setDataPedido(aluguel.getDataPedido().getTime());
        dto.setDataEntrega(aluguel.getDataEntrega());
        dto.setDataDevolucao(aluguel.getDataDevolucao());
        aluguel.setValorTotal(aluguel.getValorTotal());

        return dto;
    }
}
