package br.com.fiap.pos_tech_adj.tech_challenge_fase1.dto;

import br.com.fiap.pos_tech_adj.tech_challenge_fase1.entities.Pessoa;

public record CandidatoDTO(
        Long idCandidato,
        Pessoa pessoa,
        String perfilLinkedin,
        String curriculo) {
}
