package org.example.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.entity.Motorista;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MotoristaResponseDTO {
    private Long id;
    private String nome;
    private Date dataNascimento;
    private String cpf;
    private String numeroCNH;
    private String email;

    public MotoristaResponseDTO(Motorista motorista) {
        this.id = motorista.getId();
        this.nome = motorista.getNome();
        this.dataNascimento = motorista.getDataNascimento();
        this.cpf = motorista.getCpf();
        this.numeroCNH = motorista.getNumeroCNH();
        this.email = motorista.getEmail();
    }
}
