package org.example.service;

import org.example.DTO.AluguelRequestDTO;
import org.example.DTO.AluguelResponseDTO;
import org.example.entity.Aluguel;
import org.example.mappers.AluguelMapper;
import org.example.repository.AluguelRepository;
import org.example.repository.MotoristaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AluguelService {

    @Autowired
    private AluguelRepository repository;

    @Autowired
    private AluguelMapper mapper;

    @Autowired
    private MotoristaRepository motoristaRepository;

    public AluguelResponseDTO cadastrarAluguel(AluguelRequestDTO dto) {
        if (dto == null) {
            throw new RuntimeException("Impossível seguir com cadastro, dados inválidos");
        }

        Aluguel aluguel = mapper.toEntity(dto);
        Aluguel aluguelSalvo = repository.save(aluguel);
        aluguel.setCarrinho(true);

        return mapper.toDTO(aluguelSalvo);
    }

    public List<AluguelResponseDTO> listarTodosAlugueis() {
        List<Aluguel> alugueis = repository.findAll();

        return alugueis.stream()
                .map(mapper::toDTO)
                .toList();
    }

    public AluguelResponseDTO listarAluguelPorId(Long id) {
        if (id == null || id <= 0) {
            throw new RuntimeException("ID inválido.");
        }

        Aluguel aluguel = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Aluguel não encontrado."));

        return mapper.toDTO(aluguel);
    }


    public AluguelResponseDTO atualizarAluguel(Long id, AluguelRequestDTO dto) {
        Aluguel aluguel = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Aluguel com ID " + id + " não encontrado."));

        aluguel.setDataPedido(dto.getDataPedido());
        aluguel.setDataEntrega(dto.getDataEntrega());
        aluguel.setDataDevolucao(dto.getDataDevolucao());
        aluguel.setValorTotal(dto.getValorTotal());

        aluguel.setMotorista(
                motoristaRepository.findById(dto.getMotoristaId())
                        .orElseThrow(() -> new RuntimeException("Motorista com ID " + dto.getMotoristaId() + " não encontrado."))
        );

        Aluguel atualizado = repository.save(aluguel);
        return mapper.toDTO(atualizado);
    }

    public boolean deletarAluguelPorId (Long id) {
        if (id == null || id <= 0) {
            throw new RuntimeException("ID inválido.");
        }
        boolean existe = repository.existsById(id);
        if (!existe) {
            return false;
        }

        repository.deleteById(id);
        return true;
    }

    public AluguelResponseDTO confirmarAluguel(long id){
        Aluguel aluguel = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Nenhum aluguel encontrado"));

        aluguel.setCarrinho(false);
        repository.save(aluguel);

        return mapper.toDTO(aluguel);
    }
}
