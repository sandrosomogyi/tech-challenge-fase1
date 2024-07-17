package br.com.fiap.pos_tech_adj.tech_challenge_fase1.service;

import br.com.fiap.pos_tech_adj.tech_challenge_fase1.repository.BonificacaoRepository;
import br.com.fiap.pos_tech_adj.tech_challenge_fase1.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class PessoaService {

    private final PessoaRepository pessoaRepository;

    @Autowired
    public PessoaService (PessoaRepository pessoaRepository){
        this.pessoaRepository = pessoaRepository;
    }

}
