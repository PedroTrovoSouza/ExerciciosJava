package com.exercicio1.exerciciosSpring.Repository;

import com.exercicio1.exerciciosSpring.Entity.Produto;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface ProdutoRepositorio extends JpaRepository<Produto, Float> {
    @Modifying
    @Transactional
    @Query("UPDATE Produto p set p.preco = :preco WHERE p.id = :id")
    int atualizarPreco(float id , double preco);

   @Modifying
   @Transactional
   @Query("UPDATE Produto p set p.quantidade = :qtdEstoque WHERE p.id = :id")
    int atualizarEstoque(float id, int qtdEstoque);
}
