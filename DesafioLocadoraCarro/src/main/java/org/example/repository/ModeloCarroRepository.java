package org.example.repository;

import org.example.entity.ModeloCarro;
import org.example.enums.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ModeloCarroRepository extends JpaRepository<ModeloCarro, Long> {
    List<ModeloCarro> findByCategoria(Categoria categoria);
}
