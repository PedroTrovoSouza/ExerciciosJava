package com.example.demo.service;

import com.example.demo.dto.TarefaRequestDTO;
import com.example.demo.dto.TarefaResponseDTO;
import com.example.demo.entity.Tarefa;
import com.example.demo.enums.Status;
import com.example.demo.exception.TarefaInvalidaException;
import com.example.demo.mapper.TarefaMapper;
import com.example.demo.repository.TarefaRepository;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class TarefaServiceTest {

    @Mock
    private TarefaRepository repository;

    @Mock
    private TarefaMapper mapper;

    @InjectMocks
    private TarefaService service;

    private TarefaRequestDTO setarRequestDto(String nome, String descricao, Status status) {
        TarefaRequestDTO tarefaDto = new TarefaRequestDTO();
        tarefaDto.setNome(nome);
        tarefaDto.setDescricao(descricao);
        tarefaDto.setStatus(status);
        return tarefaDto;
    }

    private TarefaResponseDTO setarResponseDTO(String nome, String descricao, Status status) {
        TarefaResponseDTO response = new TarefaResponseDTO();
        response.setNome(nome);
        response.setDescricao(descricao);
        response.setStatus(status);
        return response;
    }

    private Tarefa setarTarefaEntity(String nome, String descricao, Status status) {
        Tarefa tarefa = new Tarefa();
        tarefa.setNome(nome);
        tarefa.setDescricao(descricao);
        tarefa.setStatus(status);
        return tarefa;
    }

    @Test
    void devePassarQuandoPossuirDadosValidos() {

        // ARRANGE
        TarefaRequestDTO tarefaDto = setarRequestDto(
                "Estudar Spring",
                "Revisar conceitos de JPA",
                Status.INICIO
        );
        TarefaResponseDTO respostaEsperada = setarResponseDTO(
                "Estudar Spring",
                "Revisar conceitos de JPA",
                Status.INICIO
        );
        Tarefa tarefa = setarTarefaEntity(
                "Estudar Spring",
                "Revisar conceitos de JPA",
                Status.INICIO
        );

        when(mapper.toEntity(tarefaDto)).thenReturn(tarefa);
        when(repository.save(tarefa)).thenReturn(tarefa);
        when(mapper.toDTO(tarefa)).thenReturn(respostaEsperada);

        TarefaResponseDTO resultado = service.salvar(tarefaDto);

        assertNotNull(resultado);
        assertEquals(respostaEsperada.getNome(), resultado.getNome());
        assertEquals(respostaEsperada.getDescricao(), resultado.getDescricao());
        assertEquals(respostaEsperada.getStatus(), resultado.getStatus());
    }

    @Test
    void deveLancarExcecaoQuandoDtoForNull() {
        TarefaRequestDTO tarefaDto = null;

        TarefaInvalidaException excecao = assertThrows(
                TarefaInvalidaException.class,
                () -> service.salvar(tarefaDto)
        );

        assertEquals("Impossível seguir com cadastro, dados inválidos", excecao.getMessage());
    }

//    @Test
//    void deveLancarExcecaoQuandoNomeForNull() {
//        TarefaRequestDTO tarefaDto = setarRequestDto(
//                null, // nome null
//                "Descrição válida",
//                Status.INICIO
//        );
//
//        TarefaInvalidaException excecao = assertThrows(
//                TarefaInvalidaException.class,
//                () -> service.salvar(tarefaDto)
//        );
//
//        assertEquals("Impossível seguir com cadastro, dados inválidos", excecao.getMessage());
//    }

//    @Test
//    void deveLancarExcecaoQuandoDescricaoForNull() {
//        TarefaRequestDTO tarefaDto = setarRequestDto(
//                "Nome válido",
//                null, // descrição null
//                Status.INICIO
//        );
//
//        TarefaInvalidaException excecao = assertThrows(
//                TarefaInvalidaException.class,
//                () -> service.salvar(tarefaDto)
//        );
//
//        assertEquals("Impossível seguir com cadastro, dados inválidos", excecao.getMessage());
//    }

//    @Test
//    void deveLancarExcecaoQuandoStatusForNulo() {
//        TarefaRequestDTO tarefaDto = setarRequestDto(
//                "Tarefa válida",
//                "Descrição válida",
//                null // status nulo
//        );
//
//        TarefaInvalidaException excecao = assertThrows(
//                TarefaInvalidaException.class,
//                () -> service.salvar(tarefaDto)
//        );
//
//        assertEquals("Impossível seguir com cadastro, dados inválidos", excecao.getMessage());
//    }

    @Test
    void deveLancarExcecaoQuandoNomeForEmBranco() {
        TarefaRequestDTO tarefaDto = setarRequestDto(
                "   ", // nome em branco
                "Descrição válida",
                Status.INICIO
        );

        TarefaInvalidaException excecao = assertThrows(
                TarefaInvalidaException.class,
                () -> service.salvar(tarefaDto)
        );

        assertEquals("Impossível seguir com cadastro, dados inválidos", excecao.getMessage());
    }


    @Test
    void deveLancarExcecaoQuandoDescricaoForEmBranco() {
        TarefaRequestDTO tarefaDto = setarRequestDto(
                "Tarefa válida",
                "   ", // descrição em branco
                Status.INICIO
        );

        TarefaInvalidaException excecao = assertThrows(
                TarefaInvalidaException.class,
                () -> service.salvar(tarefaDto)
        );

        assertEquals("Impossível seguir com cadastro, dados inválidos", excecao.getMessage());
    }

    @Test
    void deveRetornarListaDeTarefasQuandoExistiremTarefasCadastradas() {
        // ARRANGE
        Tarefa tarefa1 = setarTarefaEntity("Estudar Spring", "Revisar conceitos de JPA", Status.INICIO);
        Tarefa tarefa2 = setarTarefaEntity("Fazer testes", "Criar testes unitários", Status.FIM);

        TarefaResponseDTO dto1 = setarResponseDTO("Estudar Spring", "Revisar conceitos de JPA", Status.INICIO);
        TarefaResponseDTO dto2 = setarResponseDTO("Fazer testes", "Criar testes unitários", Status.FIM);

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
        assertEquals(respostaEsperada.get(1).getDescricao(), resultado.get(1).getDescricao());
    }

    @Test
    void deveLancarExcecaoQuandoIdInvalidoAoListarPorId() {
        // ARRANGE
        Long idInvalido = -1L;

        // ACT & ASSERT
        TarefaInvalidaException excecao = assertThrows(
                TarefaInvalidaException.class,
                () -> service.listarTarefaPorId(idInvalido)
        );

        assertEquals("ID inválido.", excecao.getMessage());
    }

    @Test
    void deveAtualizarTarefaComSucesso() {
        // ARRANGE
        Long id = 1L;

        TarefaRequestDTO dto = setarRequestDto(
                "Atualizar Tarefa",
                "Nova descrição",
                Status.FIM
        );

        Tarefa existente = setarTarefaEntity(
                "Nome antigo",
                "Descrição antiga",
                Status.INICIO
        );
        existente.setId(id);

        Tarefa atualizado = setarTarefaEntity(
                "Atualizar Tarefa",
                "Nova descrição",
                Status.FIM
        );
        atualizado.setId(id);

        TarefaResponseDTO respostaEsperada = setarResponseDTO(
                "Atualizar Tarefa",
                "Nova descrição",
                Status.FIM
        );

        when(repository.findById(id)).thenReturn(Optional.of(existente));
        when(repository.save(any(Tarefa.class))).thenReturn(atualizado);
        when(mapper.toDTO(atualizado)).thenReturn(respostaEsperada);

        // ACT
        TarefaResponseDTO resultado = service.atualizarTarefa(id, dto);

        // ASSERT
        assertNotNull(resultado);
        assertEquals(respostaEsperada.getNome(), resultado.getNome());
        assertEquals(respostaEsperada.getDescricao(), resultado.getDescricao());
        assertEquals(respostaEsperada.getStatus(), resultado.getStatus());
    }


    @Test
    void deveLancarExcecaoQuandoIdInvalidoAoDeletarPorId() {
        // ARRANGE
        Long idInvalido = -1L;

        // ACT & ASSERT
        TarefaInvalidaException excecao = assertThrows(
                TarefaInvalidaException.class,
                () -> service.deletarPorId(idInvalido)
        );

        assertEquals("ID inválido.", excecao.getMessage());
    }
}