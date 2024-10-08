package br.com.fiap.pos_tech_adj.tech_challenge_fase1.service;

import br.com.fiap.pos_tech_adj.tech_challenge_fase1.controller.exception.ControllerDatabaseException;
import br.com.fiap.pos_tech_adj.tech_challenge_fase1.controller.exception.ControllerNotFoundException;
import br.com.fiap.pos_tech_adj.tech_challenge_fase1.dto.BonificacaoDTO;
import br.com.fiap.pos_tech_adj.tech_challenge_fase1.entities.Bonificacao;
import br.com.fiap.pos_tech_adj.tech_challenge_fase1.repository.BonificacaoRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class BonificacaoService {

    private final BonificacaoRepository bonificacaoRepository;

    @Autowired
    private EmailService emailService;

    @Autowired
    public BonificacaoService (BonificacaoRepository bonificacaoRepository){
        this.bonificacaoRepository = bonificacaoRepository;
    }

    public Page<BonificacaoDTO> findAll (Pageable pageable){
        Page<Bonificacao> bonificacoes = bonificacaoRepository.findAll(pageable);
        return bonificacoes.map(this::toDTO);
    }

    public BonificacaoDTO findById(Long id){
        Bonificacao bonificacao = bonificacaoRepository.findById(id)
                .orElseThrow(() -> new ControllerNotFoundException("Bonificação não encontrada"));
        return toDTO(bonificacao);
    }

    public BonificacaoDTO save(BonificacaoDTO bonificacaoDTO){
        try{
            Bonificacao bonificacao = bonificacaoRepository.save(toEntity(bonificacaoDTO));
            return toDTO(bonificacao);
        }
        catch (EntityNotFoundException e){
            throw new ControllerNotFoundException("Entidade não encontrada");
        }
        catch (DataIntegrityViolationException e){
            throw new ControllerDatabaseException("Erro no database causado por: " + e.getMessage());
        }
    }

    public BonificacaoDTO update(Long id, BonificacaoDTO bonificacaoDTO){
        try{
            Bonificacao bonificacao = bonificacaoRepository.getReferenceById(id);

            bonificacao.setVaga(bonificacaoDTO.vaga());
            bonificacao.setColaborador(bonificacaoDTO.colaborador());
            bonificacao.setCandidato(bonificacaoDTO.candidato());
            bonificacao.setContratacao(bonificacaoDTO.contratacao());
            bonificacao.setDataBonificacao(bonificacaoDTO.dataBonificacao());

            if (bonificacao.isEfetuada() != bonificacaoDTO.efetuada()){

                bonificacao.setEfetuada(bonificacaoDTO.efetuada());

                if (bonificacaoDTO.efetuada()) {
                    emailService.sendEmail(bonificacao.getColaborador().getPessoa().getEmail(),
                            "Bonificação",
                            "Sua Bonificação referente a Vaga: " + bonificacao.getVaga().getTitulo() +
                                    " Atendeu a todas as regras e será efetuada em breve.");
                }else {
                    emailService.sendEmail(bonificacao.getColaborador().getPessoa().getEmail(),
                            "Bonificação",
                            "Sua Bonificação referente a Vaga: " + bonificacao.getVaga().getTitulo() +
                                    " Não atendeu a todas as regras e não iremos prosseguir com a Bonificação.");
                }
            }

            bonificacao = bonificacaoRepository.save(bonificacao);
            return toDTO(bonificacao);
        }
        catch (EntityNotFoundException e){
            throw new ControllerNotFoundException("Bonificação não encontrada");
        }
    }

    public void delete(Long id){
        bonificacaoRepository.deleteById(id);
    }

    private BonificacaoDTO toDTO(Bonificacao bonificacao) {
        return new BonificacaoDTO(
                bonificacao.getId(),
                bonificacao.getVaga(),
                bonificacao.getColaborador(),
                bonificacao.getCandidato(),
                bonificacao.getContratacao(),
                bonificacao.getDataBonificacao(),
                bonificacao.isEfetuada()
                );
    }

    private Bonificacao toEntity(BonificacaoDTO bonificacaoDTO) {
        return new Bonificacao(
                bonificacaoDTO.id(),
                bonificacaoDTO.vaga(),
                bonificacaoDTO.colaborador(),
                bonificacaoDTO.candidato(),
                bonificacaoDTO.contratacao(),
                bonificacaoDTO.dataBonificacao(),
                bonificacaoDTO.efetuada()
        );
    }
}
