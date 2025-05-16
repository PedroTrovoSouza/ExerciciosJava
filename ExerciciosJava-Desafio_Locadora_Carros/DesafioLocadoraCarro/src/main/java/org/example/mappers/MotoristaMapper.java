package org.example.mappers;

import org.example.DTO.MotoristaRequestDTO;
import org.example.DTO.MotoristaResponseDTO;
import org.example.entity.Motorista;
import org.springframework.stereotype.Component;

@Component
public class MotoristaMapper {

    public Motorista toEntity(MotoristaRequestDTO dto) {
        Motorista motorista = new Motorista();
        motorista.setNome(dto.getNome());
        motorista.setCpf(dto.getCpf());
        motorista.setDataNascimento(dto.getDataNascimento());
        motorista.setNumeroCNH(dto.getNumeroCNH());
        motorista.setEmail(dto.getEmail());
        return motorista;
    }

    public MotoristaResponseDTO toDTO(Motorista entity) {
        MotoristaResponseDTO dto = new MotoristaResponseDTO();
        dto.setId(entity.getId()); // campo id está como "integer" na classe Pessoa
        dto.setNome(entity.getNome());
        dto.setCpf(entity.getCpf());
        dto.setDataNascimento(entity.getDataNascimento());
        dto.setNumeroCNH(entity.getNumeroCNH());
        dto.setEmail(entity.getEmail());
        return dto;
    }
}
