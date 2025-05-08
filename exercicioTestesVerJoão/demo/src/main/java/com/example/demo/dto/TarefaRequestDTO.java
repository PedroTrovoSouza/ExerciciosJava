package com.example.demo.dto;

import com.example.demo.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TarefaRequestDTO {
    private String nome;
    private String descricao;
    private Status status;
}
