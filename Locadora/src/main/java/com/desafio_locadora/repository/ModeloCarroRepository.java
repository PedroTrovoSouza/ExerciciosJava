package com.desafio_locadora.repository;

import com.desafio_locadora.entity.ModeloCarro;
import com.desafio_locadora.tipos.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ModeloCarroRepository extends JpaRepository<ModeloCarro, Long> {
    List<ModeloCarro> findByCategoria(Categoria categoria);
}
