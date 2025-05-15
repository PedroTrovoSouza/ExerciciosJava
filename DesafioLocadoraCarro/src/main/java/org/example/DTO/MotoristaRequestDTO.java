package org.example.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.antlr.v4.runtime.misc.NotNull;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MotoristaRequestDTO {
    private String nome;

    @NotNull
    private Date dataNascimento;

    private String cpf;

    private String numeroCNH;

    private String email;
}
