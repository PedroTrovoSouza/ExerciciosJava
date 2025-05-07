package com.gerenciador_de_tarefa.GerenciadorDeTarefa.controller;

import com.gerenciador_de_tarefa.GerenciadorDeTarefa.dto.ListagemTaskDTO;
import com.gerenciador_de_tarefa.GerenciadorDeTarefa.dto.TaskDTO;
import com.gerenciador_de_tarefa.GerenciadorDeTarefa.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/task")
public class TaskController {

    @Autowired
    TaskService taskService;

    @PostMapping
    public ResponseEntity<TaskDTO> postTask(@RequestBody TaskDTO novaTask){
        taskService.postTask(novaTask);

        return ResponseEntity.status(201).body(novaTask);
    }

    @GetMapping
    public ResponseEntity<List<ListagemTaskDTO>> listarTasks(){
       return ResponseEntity.status(200).body(taskService.listarTasks());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ListagemTaskDTO> getTaskEspecifica(@PathVariable long id){
        return ResponseEntity.status(200).body(taskService.buscarTaskPorId(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity putTask(@RequestBody TaskDTO taskDTO, @PathVariable long id){
        return ResponseEntity.status(200).body(taskService.editarTask(taskDTO, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletPorId(@PathVariable long id){
        taskService.deletarPorId(id);

        return ResponseEntity.status(200).build();
    }
}
