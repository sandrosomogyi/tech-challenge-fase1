package br.com.fiap.pos_tech_adj.tech_challenge_fase1.service;

import br.com.fiap.pos_tech_adj.tech_challenge_fase1.repository.BonificacaoRepository;
import br.com.fiap.pos_tech_adj.tech_challenge_fase1.repository.VagaRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class VagaService {

    private final VagaRepository vagaRepository;

    @Autowired
    public VagaService (VagaRepository vagaRepository){
        this.vagaRepository = vagaRepository;
    }
}
