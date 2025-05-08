package com.br.locadora.Locadora.repository;

import com.br.locadora.Locadora.entity.Locacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocadoraRepository extends JpaRepository<Locacao, Long>{

}
