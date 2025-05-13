package com.example.demo.service;

import com.example.demo.dto.TarefaRequestDTO;
import com.example.demo.dto.TarefaResponseDTO;
import com.example.demo.entity.Tarefa;
import com.example.demo.exception.TarefaInvalidaException;
import com.example.demo.mapper.TaskMapper;
import com.example.demo.repository.TarefaRepository;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class TarefaServiceTest {

    @Mock
    private TarefaRepository repository;

    @Mock
    private TaskMapper mapper;

    @InjectMocks
    private TarefaService service;

    private TarefaRequestDTO setarRequestDto(String nome) {
        TarefaRequestDTO tarefaDto = new TarefaRequestDTO();
        tarefaDto.setNome(nome);
        return tarefaDto;
    }

    private TarefaResponseDTO setarResponseDTO(String nome) {
        TarefaResponseDTO response = new TarefaResponseDTO();
        response.setNome(nome);
        return response;
    }

    private Tarefa setarTarefaEntity(String nome) {
        Tarefa tarefa = new Tarefa();
        tarefa.setNome(nome);
        return tarefa;
    }

    @Test
    void devePassarQuandoPossuirDadosValidos() {

        // ARRANGE
        TarefaRequestDTO tarefaDto = setarRequestDto(
                "Estudar Spring"
        );
        TarefaResponseDTO respostaEsperada = setarResponseDTO(
                "Estudar Spring"
        );
        Tarefa tarefa = setarTarefaEntity(
                "Estudar Spring"
        );

        when(mapper.toEntity(tarefaDto)).thenReturn(tarefa);
        when(repository.save(tarefa)).thenReturn(tarefa);
        when(mapper.toDTO(tarefa)).thenReturn(respostaEsperada);

        TarefaResponseDTO resultado = service.salvar(tarefaDto);

        assertNotNull(resultado);
        assertEquals(respostaEsperada.getNome(), resultado.getNome());
    }

    @Test
    void deveRetornarListaDeTarefasQuandoExistiremTarefasCadastradas() {
        // ARRANGE
        Tarefa tarefa1 = setarTarefaEntity("Estudar Spring");
        Tarefa tarefa2 = setarTarefaEntity("Fazer testes");

        TarefaResponseDTO dto1 = setarResponseDTO("Estudar Spring");
        TarefaResponseDTO dto2 = setarResponseDTO("Fazer testes");

        List<Tarefa> tarefasMockadas = List.of(tarefa1, tarefa2);
        List<TarefaResponseDTO> respostaEsperada = List.of(dto1, dto2);

        when(repository.findAll()).thenReturn(tarefasMockadas);
        when(mapper.toDTO(tarefa1)).thenReturn(dto1);
        when(mapper.toDTO(tarefa2)).thenReturn(dto2);

        // ACT
        List<TarefaResponseDTO> resultado = service.listarTodasTarefas();

        // ASSERT
        assertNotNull(resultado);
        assertEquals(2, resultado.size());
        assertEquals(respostaEsperada.get(0).getNome(), resultado.get(0).getNome());
    }

    @Test
    void deveLancarExcecaoQuandoNomeInvalidoAoDeletarPorNome() {
        // ARRANGE
        String idInvalido = "";

        // ACT & ASSERT
        TarefaInvalidaException excecao = assertThrows(
                TarefaInvalidaException.class,
                () -> service.deletarPorNome(idInvalido)
        );

        assertEquals("ID inválido.", excecao.getMessage());
    }
}