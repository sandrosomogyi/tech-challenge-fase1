package br.com.fiap.pos_tech_adj.tech_challenge_fase1.dto;

import br.com.fiap.pos_tech_adj.tech_challenge_fase1.entities.Colaborador;
import br.com.fiap.pos_tech_adj.tech_challenge_fase1.entities.Pessoa;
import br.com.fiap.pos_tech_adj.tech_challenge_fase1.entities.Vaga;

import java.time.LocalDate;

public record CandidatoDTO(
        Long id,
        Pessoa pessoa,
        String perfilLinkedin,
        String curriculo,
        Colaborador colaborador
    ) {
}
