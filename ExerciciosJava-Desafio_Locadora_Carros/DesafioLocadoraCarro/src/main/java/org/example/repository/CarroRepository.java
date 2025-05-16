package org.example.repository;

import org.example.entity.Carro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface CarroRepository extends JpaRepository<Carro, Long> {

    List<Carro> findByAcessorioDescricao(String descricao);

    @Query("""
        SELECT c FROM Carro c
        WHERE NOT EXISTS (
            SELECT a FROM Aluguel a
            WHERE a.carro = c AND (
                a.dataDevolucao IS NULL OR CURRENT_DATE BETWEEN a.dataEntrega AND a.dataDevolucao
            )
        )
    """)
    List<Carro> findCarrosDisponiveis();
}



