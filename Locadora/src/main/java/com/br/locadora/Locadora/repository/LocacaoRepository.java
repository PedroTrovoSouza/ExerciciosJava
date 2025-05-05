package com.br.locadora.Locadora.repository;

import com.br.locadora.Locadora.entity.Locacao;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.Optional;

public interface LocacaoRepository extends JpaRepository<Locacao, Long> {

    @Query("select l from Locacao l join l.filme f where f.id = :filmeId and l.devolvido = false")
    Optional<Locacao> verificarFilmeAlugado(@Param("filmeId") long id);

    @Transactional
    @Modifying
    @Query("update Locacao l set l.devolvido = true, l.dataDevolucao = :dataDevolucao where l.id = :id")
    int devolverFilme(long id, LocalDate dataDevolucao);
}
