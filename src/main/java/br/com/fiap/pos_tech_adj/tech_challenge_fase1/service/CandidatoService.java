package br.com.fiap.pos_tech_adj.tech_challenge_fase1.service;

import br.com.fiap.pos_tech_adj.tech_challenge_fase1.repository.BonificacaoRepository;
import br.com.fiap.pos_tech_adj.tech_challenge_fase1.repository.CandidatoRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class CandidatoService {

    private final CandidatoRepository candidatoRepository;

    @Autowired
    public CandidatoService (CandidatoRepository candidatoRepository){
        this.candidatoRepository = candidatoRepository;
    }
}
