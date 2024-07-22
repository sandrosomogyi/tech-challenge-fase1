package br.com.fiap.pos_tech_adj.tech_challenge_fase1.dto;

import br.com.fiap.pos_tech_adj.tech_challenge_fase1.entities.Candidato;
import br.com.fiap.pos_tech_adj.tech_challenge_fase1.entities.Colaborador;
import br.com.fiap.pos_tech_adj.tech_challenge_fase1.entities.Contratacao;
import br.com.fiap.pos_tech_adj.tech_challenge_fase1.entities.Vaga;

import java.time.LocalDate;

public record BonificacaoDTO(
        Long idBonificacao,
        Vaga vaga,
        Colaborador colaborador,
        Candidato candidato,
        Contratacao contratacao,
        LocalDate dataBonificacao,
        boolean efetuada) {
}