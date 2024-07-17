package br.com.fiap.pos_tech_adj.tech_challenge_fase1.service;

import br.com.fiap.pos_tech_adj.tech_challenge_fase1.repository.BonificacaoRepository;
import br.com.fiap.pos_tech_adj.tech_challenge_fase1.repository.IndicacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class IndicacaoService {

    private final IndicacaoRepository indicacaoRepository;

    @Autowired
    public IndicacaoService (IndicacaoRepository indicacaoRepository){
        this.indicacaoRepository = indicacaoRepository;
    }
}
