package com.example.demo.controller;

import com.example.demo.dto.TarefaRequestDTO;
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

    private TarefaRequestDTO criarTarefa(String nome) {
        TarefaRequestDTO novaTarefa = new TarefaRequestDTO();
        novaTarefa.setNome(nome);
        return novaTarefa;
    }

    @Test
    void deveSalvarTarefa() throws Exception {
        TarefaRequestDTO novaTarefa = criarTarefa(
            "Estudar Spring"
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
    void deveDeletarTarefa() throws Exception {
        // Cria tarefa antes de deletar
        TarefaRequestDTO tarefa = criarTarefa(
                "Estudar Spring"
        );

        String resposta = mockMvc.perform(post("/tarefas")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(tarefa)))
                .andReturn()
                .getResponse()
                .getContentAsString();

        String nome = objectMapper.readTree(resposta).get("nome").asToken().asString();

        mockMvc.perform(delete("/tarefas/" + nome))
                .andExpect(status().isNoContent());
    }
}
