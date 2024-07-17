package br.com.fiap.pos_tech_adj.tech_challenge_fase1.service;

import br.com.fiap.pos_tech_adj.tech_challenge_fase1.repository.BonificacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BonificacaoService {

    private final BonificacaoRepository bonificacaoRepository;

    @Autowired
    public BonificacaoService (BonificacaoRepository bonificacaoRepository){
        this.bonificacaoRepository = bonificacaoRepository;
    }


}
