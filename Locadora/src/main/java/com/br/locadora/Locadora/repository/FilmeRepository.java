package com.br.locadora.Locadora.repository;

import com.br.locadora.Locadora.entity.Filme;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FilmeRepository extends JpaRepository<Filme, Long> {

    Filme findByTitulo(String titulo);
}
