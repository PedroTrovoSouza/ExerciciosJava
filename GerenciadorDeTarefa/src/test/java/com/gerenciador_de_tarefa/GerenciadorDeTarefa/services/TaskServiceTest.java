package com.gerenciador_de_tarefa.GerenciadorDeTarefa.services;

import com.gerenciador_de_tarefa.GerenciadorDeTarefa.dto.ListagemTaskDTO;
import com.gerenciador_de_tarefa.GerenciadorDeTarefa.dto.TaskDTO;
import com.gerenciador_de_tarefa.GerenciadorDeTarefa.entity.Task;
import com.gerenciador_de_tarefa.GerenciadorDeTarefa.repository.TaskRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.mockito.BDDMockito.given;
import static com.gerenciador_de_tarefa.GerenciadorDeTarefa.entity.Status.EM_ANDAMENTO;


@ExtendWith(MockitoExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
public class TaskServiceTest {

    @Mock
    TaskRepository taskRepository;

    @InjectMocks
    TaskService taskService;

    private TaskDTO taskDTO;
    private Task task;

    @BeforeEach
    void setUp(){
        taskDTO = new TaskDTO("CRUD", "Desenvolver o CRUD", EM_ANDAMENTO);
        task = new Task(taskDTO);
    }

    @Test
    void saveTask() throws Exception{
        Assertions.assertDoesNotThrow(() -> taskService.postTask(taskDTO));
    }

    @Test
    void buscarTaskPorId() throws Exception {
        given(taskRepository.findById(1l)).willReturn(Optional.empty());

        Assertions.assertThrows(RuntimeException.class, () -> taskService.buscarTaskPorId(1l));
    }

    @Test
    void listarTasks() throws Exception{
        List<Task> listaVazia = Collections.emptyList();
        given(taskRepository.findAll()).willReturn(listaVazia);

        Assertions.assertThrows(RuntimeException.class, () -> taskService.listarTasks());
    }

    @Test
    void updateTask() throws Exception{

    }
}
