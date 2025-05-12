package com.desafio_locadora.repository;

import com.desafio_locadora.entity.Acessorio;
import com.desafio_locadora.entity.Carro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface CarroRepository extends JpaRepository<Carro, Long> {
    List<Carro> findByAcessorioDescricao(String descricao);
}



