package br.com.fiap.pos_tech_adj.tech_challenge_fase1.dto;

import br.com.fiap.pos_tech_adj.tech_challenge_fase1.entities.Bonificacao;
import br.com.fiap.pos_tech_adj.tech_challenge_fase1.entities.Indicacao;
import br.com.fiap.pos_tech_adj.tech_challenge_fase1.entities.Pessoa;
import java.time.LocalDate;
import java.util.List;

public record ColaboradorDTO(
        Long id,
        String departamento,
        String cargo,
        LocalDate dataContratacao,
        Pessoa pessoa,
        List<Indicacao> indicacoes,
        List<Bonificacao> bonificacoes
) {
}
