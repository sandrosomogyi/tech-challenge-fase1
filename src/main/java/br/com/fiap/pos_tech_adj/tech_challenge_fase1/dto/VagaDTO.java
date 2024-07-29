package br.com.fiap.pos_tech_adj.tech_challenge_fase1.dto;

import java.util.List;

public record VagaDTO(
                Long idVaga,
                String titulo,
                String descricao,
                String requisitosObrigatorios,
                String requisitosDesejaveis,
                String beneficios,
                String tipoContratacao,
                Double remuneracao,
                Double valorBonificacao,
                String observacoes,
                List<IndicacaoDTO> indicacoes) {

}
