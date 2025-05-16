package org.example.service;

import org.example.DTO.MotoristaRequestDTO;
import org.example.DTO.MotoristaResponseDTO;
import org.example.entity.Motorista;
import org.example.excecoes.EmailJaCadastradoException;
import org.example.mappers.MotoristaMapper;
import org.example.repository.MotoristaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MotoristaService {

    @Autowired
    private MotoristaRepository repository;

    @Autowired
    private MotoristaMapper mapper;

    public MotoristaResponseDTO cadastrarMotorista (MotoristaRequestDTO dto) {
        boolean existePorEmail = repository.findByEmailEqualsIgnoreCase(dto.getEmail());

        if (existePorEmail) {
            throw new EmailJaCadastradoException("Impossível seguir com cadastro, e-mail já está em uso");
        }

        Motorista motorista = mapper.toEntity(dto);
        Motorista motoristaSalvo = repository.save(motorista);
        return mapper.toDTO(motoristaSalvo);
    }

    public List<MotoristaResponseDTO> listarTodosMotoristas () {
        List<Motorista> motoristas = repository.findAll();

        return motoristas.stream()
                .map(mapper::toDTO)
                .toList();
    }

    public MotoristaResponseDTO listarMotoristaPorId (Long id) {
        if (id == null || id <= 0) {
            throw new RuntimeException("ID inválido.");
        }

        Motorista motorista = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Motorista não Encontrado."));

        return mapper.toDTO(motorista);
    }
}
