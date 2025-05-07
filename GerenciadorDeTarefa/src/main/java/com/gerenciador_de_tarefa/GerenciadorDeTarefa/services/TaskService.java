package com.gerenciador_de_tarefa.GerenciadorDeTarefa.services;

import com.gerenciador_de_tarefa.GerenciadorDeTarefa.dto.ListagemTaskDTO;
import com.gerenciador_de_tarefa.GerenciadorDeTarefa.dto.TaskDTO;
import com.gerenciador_de_tarefa.GerenciadorDeTarefa.entity.Task;
import com.gerenciador_de_tarefa.GerenciadorDeTarefa.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    @Autowired
    TaskRepository taskRepository;

    public void postTask(TaskDTO novaTaskDto){
        if (novaTaskDto != null){
            taskRepository.save(new Task(novaTaskDto));
        }
    }

    public List<ListagemTaskDTO> listarTasks(){
       List<Task> listaTask = taskRepository.findAll();

       if(listaTask.isEmpty()){
           throw new RuntimeException("Nenhuma task foi encontrada!!");
       }

       return listToDTO(listaTask);
    }

    public ListagemTaskDTO buscarTaskPorId(long id) {
        Optional<Task> taskEncontrada = taskRepository.findById(id);

        if (!taskEncontrada.isPresent()) {
            throw new RuntimeException("Task não encontrada!!");
        }
        Task task = taskEncontrada.get();

        return toDTO(task);
    }


    public Optional<Task> editarTask(TaskDTO taskAtualizado, long id){
        Optional<Task> taskEncontrada = taskRepository.findById(id);

        if(!taskEncontrada.isEmpty()){
            taskEncontrada.get().setTitle(taskAtualizado.title());
            taskEncontrada.get().setDescription(taskAtualizado.description());
            taskEncontrada.get().setStatus(taskAtualizado.status());

            taskRepository.save(taskEncontrada.get());

            return taskEncontrada;
        }
        return null;
    }

    public void deletarPorId(long id){
        taskRepository.deleteById(id);
    }

    public ListagemTaskDTO toDTO(Task task){
        ListagemTaskDTO listagemTaskDTO = new ListagemTaskDTO(task.getTitle(), task.getDescription());

        return listagemTaskDTO;
    }

    public List<ListagemTaskDTO> listToDTO(List<Task> tasks){
        List<ListagemTaskDTO> listaTask = new ArrayList<>();
        tasks.forEach(t -> listaTask.add(new ListagemTaskDTO(t.getTitle(), t.getDescription())));

        return listaTask;
    }

}
