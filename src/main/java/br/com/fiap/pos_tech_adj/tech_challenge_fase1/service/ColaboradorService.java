package br.com.fiap.pos_tech_adj.tech_challenge_fase1.service;

import br.com.fiap.pos_tech_adj.tech_challenge_fase1.repository.BonificacaoRepository;
import br.com.fiap.pos_tech_adj.tech_challenge_fase1.repository.ColaboradorRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class ColaboradorService {

    private final ColaboradorRepository colaboradorRepository;

    @Autowired
    public ColaboradorService (ColaboradorRepository colaboradorRepository){
        this.colaboradorRepository = colaboradorRepository;
    }

}
