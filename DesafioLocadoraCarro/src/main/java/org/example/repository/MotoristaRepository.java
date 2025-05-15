package org.example.repository;

import org.example.entity.Motorista;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MotoristaRepository extends JpaRepository<Motorista, Long> {
    boolean findByEmailEqualsIgnoreCase (String email);
}