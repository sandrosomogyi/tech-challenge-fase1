package br.com.fiap.pos_tech_adj.tech_challenge_fase1.dto;

import br.com.fiap.pos_tech_adj.tech_challenge_fase1.entities.Pessoa;
import java.time.LocalDate;

public record ColaboradorDTO(
        Long idColaborador,
        String departamento,
        String cargo,
        LocalDate dataContratacao,
        Pessoa pessoa
) {
}
