package com.br.locadora.Locadora.repository;

import com.br.locadora.Locadora.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Float>{

    Cliente findByNome(String nome);
}
