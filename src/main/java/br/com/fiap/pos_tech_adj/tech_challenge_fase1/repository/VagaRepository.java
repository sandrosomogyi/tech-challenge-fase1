package br.com.fiap.pos_tech_adj.tech_challenge_fase1.repository;

import br.com.fiap.pos_tech_adj.tech_challenge_fase1.entities.Vaga;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VagaRepository extends JpaRepository<Vaga, Long> {
    
}
