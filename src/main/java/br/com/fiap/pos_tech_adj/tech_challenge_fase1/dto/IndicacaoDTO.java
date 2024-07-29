package br.com.fiap.pos_tech_adj.tech_challenge_fase1.dto;

import br.com.fiap.pos_tech_adj.tech_challenge_fase1.entities.Colaborador;
import br.com.fiap.pos_tech_adj.tech_challenge_fase1.entities.Vaga;

public record IndicacaoDTO(
                Long idIndicacao,
                Vaga vaga,
                Colaborador colaborador,
                String telefoneCandidato,
                String emailCandidato,
                String curriculoCandidato,
                String perfilCandidato,
                String observacoes,
                boolean validado) {
}
