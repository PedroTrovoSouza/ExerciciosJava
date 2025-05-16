package org.example.repository;

import org.example.entity.Acessorio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AcessorioRepository extends JpaRepository<Acessorio, Long> {
    List<Acessorio> findByDescricaoContaining(String descricao);
}
