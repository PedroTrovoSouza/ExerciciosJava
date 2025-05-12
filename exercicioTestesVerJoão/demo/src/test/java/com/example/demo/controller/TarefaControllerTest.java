package com.example.demo.controller;

import com.example.demo.dto.TarefaRequestDTO;
import com.example.demo.enums.Status;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class TarefaControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    private TarefaRequestDTO criarTarefa(String nome, String descricao, Status status) {
        TarefaRequestDTO novaTarefa = new TarefaRequestDTO();
        novaTarefa.setNome(nome);
        novaTarefa.setDescricao(descricao);
        novaTarefa.setStatus(status);
        return novaTarefa;
    }

    @Test
    void deveSalvarTarefa() throws Exception {
        TarefaRequestDTO novaTarefa = criarTarefa(
            "Estudar Spring",
                "Ler a documentação do Spring Boot",
                Status.INICIO
        );

        mockMvc.perform(post("/tarefas")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(novaTarefa)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.nome").value("Estudar Spring"));
    }

    @Test
    void deveListarTodasAsTarefas() throws Exception {
        mockMvc.perform(get("/tarefas"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", isA(java.util.List.class)));
    }

    @Test
    void deveRetornarTarefaPorId() throws Exception {
        // Primeiro, salva uma tarefa para testar o GET /{id}
        TarefaRequestDTO novaTarefa = criarTarefa(
                "Estudar Spring",
                "Ler a documentação do Spring Boot",
                Status.INICIO
        );

        String resposta = mockMvc.perform(post("/tarefas")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(novaTarefa)))
                .andExpect(status().isCreated())
                .andReturn()
                .getResponse()
                .getContentAsString();

        Long idCriado = objectMapper.readTree(resposta).get("id").asLong();

        mockMvc.perform(get("/tarefas/" + idCriado))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.nome").value("Buscar Tarefa"));
    }

    @Test
    void deveAtualizarTarefa() throws Exception {
        // Primeiro cria
        TarefaRequestDTO tarefa = criarTarefa(
                "Estudar Spring",
                "Ler a documentação do Spring Boot",
                Status.INICIO
        );

        String resposta = mockMvc.perform(post("/tarefas")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(tarefa)))
                .andReturn()
                .getResponse()
                .getContentAsString();

        Long id = objectMapper.readTree(resposta).get("id").asLong();

        // Atualiza
        tarefa.setNome("Nome Atualizado");
        tarefa.setDescricao("Descrição Atualizada");

        mockMvc.perform(put("/tarefas/" + id)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(tarefa)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.nome").value("Nome Atualizado"));
    }

    @Test
    void deveDeletarTarefa() throws Exception {
        // Cria tarefa antes de deletar
        TarefaRequestDTO tarefa = criarTarefa(
                "Estudar Spring",
                "Ler a documentação do Spring Boot",
                Status.INICIO
        );

        String resposta = mockMvc.perform(post("/tarefas")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(tarefa)))
                .andReturn()
                .getResponse()
                .getContentAsString();

        Long id = objectMapper.readTree(resposta).get("id").asLong();

        mockMvc.perform(delete("/tarefas/" + id))
                .andExpect(status().isNoContent());
    }
}
