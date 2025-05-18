package org.example.mappers;

import org.example.DTO.AluguelRequestDTO;
import org.example.DTO.AluguelResponseDTO;
import org.example.DTO.MotoristaResponseDTO;
import org.example.entity.Aluguel;
import org.example.repository.ApoliceSeguroRepository;
import org.example.repository.MotoristaRepository;
import org.springframework.stereotype.Component;

@Component
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

    public AluguelResponseDTO toDTO(Aluguel aluguel) {
        AluguelResponseDTO dto = new AluguelResponseDTO();

        dto.setId(aluguel.getId());
        dto.setDataPedido(aluguel.getDataPedido() != null ? aluguel.getDataPedido().getTime() : null);
        dto.setDataEntrega(aluguel.getDataEntrega());
        dto.setDataDevolucao(aluguel.getDataDevolucao());
        dto.setValorTotal(aluguel.getValorTotal());

        if (aluguel.getMotorista() != null) {
            MotoristaResponseDTO motoristaDTO = new MotoristaResponseDTO();
            motoristaDTO.setId(aluguel.getMotorista().getId());
            motoristaDTO.setNome(aluguel.getMotorista().getNome());
            motoristaDTO.setDataNascimento(aluguel.getMotorista().getDataNascimento());
            motoristaDTO.setCpf(aluguel.getMotorista().getCpf());
            motoristaDTO.setNumeroCNH(aluguel.getMotorista().getNumeroCNH());
            motoristaDTO.setEmail(aluguel.getMotorista().getEmail());
            dto.setMotorista(motoristaDTO);
        }

        return dto;
    }
}
