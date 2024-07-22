package br.com.fiap.pos_tech_adj.tech_challenge_fase1.dto;

import br.com.fiap.pos_tech_adj.tech_challenge_fase1.entities.Pessoa;

public record ColaboradorDTO(
        Long idColaborador,
        Pessoa pessoa
) {
}
