package br.com.fiap.pos_tech_adj.tech_challenge_fase1.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.pos_tech_adj.tech_challenge_fase1.dto.VagaDTO;
import br.com.fiap.pos_tech_adj.tech_challenge_fase1.entities.Indicacao;

public interface IndicacaoRepository extends JpaRepository<Indicacao, Long> {

    List<VagaDTO> findByVagaId(Long idVaga);
}
