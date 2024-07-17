package br.com.fiap.pos_tech_adj.tech_challenge_fase1.service;

import br.com.fiap.pos_tech_adj.tech_challenge_fase1.repository.BonificacaoRepository;
import br.com.fiap.pos_tech_adj.tech_challenge_fase1.repository.ContratacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class ContratacaoService {

    private final ContratacaoRepository contratacaoRepository;

    @Autowired
    public ContratacaoService (ContratacaoRepository contratacaoRepository){
        this.contratacaoRepository = contratacaoRepository;
    }

}
