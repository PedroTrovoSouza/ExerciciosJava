package com.gerenciador_de_tarefa.GerenciadorDeTarefa.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gerenciador_de_tarefa.GerenciadorDeTarefa.dto.TaskDTO;
import com.gerenciador_de_tarefa.GerenciadorDeTarefa.entity.Task;
import com.gerenciador_de_tarefa.GerenciadorDeTarefa.services.TaskServiceTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static com.gerenciador_de_tarefa.GerenciadorDeTarefa.entity.Status.EM_ANDAMENTO;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
public class TaskControllerTest {

    @Mock
    private TaskServiceTest taskService;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    private TaskDTO taskDTO;
    private Task task;

    @BeforeEach
    void setUp(){
        taskDTO = new TaskDTO("CRUD", "Desenvolver o CRUD", EM_ANDAMENTO);
        task = new Task(taskDTO);
    }

    @Test
    void saveTask() throws Exception {
        mockMvc.perform(post("/task")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(taskDTO)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.title").value("CRUD"))
                .andExpect(jsonPath("$.description").value("Desenvolver o CRUD"))
                .andExpect(jsonPath("$.status").value("EM_ANDAMENTO"));
    }

    @Test
    void getAllTask_returnsTaskList() throws Exception {
        mockMvc.perform(get("/task"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].title").value("CRUD"));

    }

    @Test
    void getTask_returnsTask() throws Exception {
        mockMvc.perform(get("/task/3"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.title").value("CRUD"));
    }

    @Test
    void deleteTask() throws Exception{
        mockMvc.perform(delete("/task/4"))
                .andExpect(status().isOk());
    }

    @Test
    void updateTask() throws Exception{
        mockMvc.perform(put("/task/3")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(taskDTO)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.title").value("CRUD"))
                .andExpect(jsonPath("$.description").value("Desenvolver o CRUD"))
                .andExpect(jsonPath("$.status").value("EM_ANDAMENTO"));
    }
}
