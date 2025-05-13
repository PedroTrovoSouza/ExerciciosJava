package org.example.mappers;

import org.example.DTO.MotoristaRequestDTO;
import org.example.DTO.MotoristaResponseDTO;
import org.example.entity.Motorista;

public class MotoristaMapper {

    public Motorista toEntity (MotoristaRequestDTO dto) {
        Motorista motorista = new Motorista();
        motorista.setNome(dto.getNome());
        motorista.setDataNascimento(dto.getDataNascimento());
        motorista.setCpf(dto.getCpf());
        motorista.setNumeroCNH(dto.getNumeroCNH());
        return motorista;
    }

    public MotoristaResponseDTO toDTO (Motorista motorista) {
        MotoristaResponseDTO dto = new MotoristaResponseDTO();
        dto.setNome(motorista.getNome());
        dto.setDataNascimento(motorista.getDataNascimento());
        dto.setCpf(motorista.getCpf());
        dto.setNumeroCNH(motorista.getNumeroCNH());
        return dto;
    }
}
