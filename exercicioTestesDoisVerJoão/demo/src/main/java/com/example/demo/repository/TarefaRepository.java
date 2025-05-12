package com.example.demo.repository;

import com.example.demo.entity.Tarefa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TarefaRepository extends JpaRepository<Tarefa, Long> {

    Optional<Tarefa> findTarefaByNomeEqualsIgnoreCase(String nome);
}
