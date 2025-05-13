package org.example.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Acessorio {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id_acessorio;

    @JsonIgnore
    @ManyToMany(
            mappedBy = "acessorio"
    )
    List<Carro> carros;

    private String descricao;
}
