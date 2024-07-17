package br.com.fiap.pos_tech_adj.tech_challenge_fase1.dto;

public record VagaDTO(
        String titulo,
        String descricao,
        String requisitosObrigatorios,
        String requisitosDesejaveis,
        String beneficios,
        String tipoContratacao,
        Double remuneracao,
        String observacoes) {
}
