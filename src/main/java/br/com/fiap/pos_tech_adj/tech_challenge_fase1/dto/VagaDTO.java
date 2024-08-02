package br.com.fiap.pos_tech_adj.tech_challenge_fase1.dto;

import br.com.fiap.pos_tech_adj.tech_challenge_fase1.entities.Indicacao;

import java.time.LocalDate;
import java.util.List;

public record VagaDTO(
                Long id,
                String titulo,
                String descricao,
                String requisitosObrigatorios,
                String requisitosDesejaveis,
                String beneficios,
                String tipoContratacao,
                Double remuneracao,
                Double valorBonificacao,
                String observacoes,
                Boolean finalizada,
                LocalDate dataVaga,
                List<Indicacao> indicacoes) {

}
