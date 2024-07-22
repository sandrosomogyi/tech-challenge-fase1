package br.com.fiap.pos_tech_adj.tech_challenge_fase1.dto;

public record PessoaDTO(
        Long idPessoa,
        String nome,
        String sobrenome,
        String telefone,
        String email) {
}
