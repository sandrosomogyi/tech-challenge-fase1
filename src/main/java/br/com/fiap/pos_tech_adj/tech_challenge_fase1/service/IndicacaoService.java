package br.com.fiap.pos_tech_adj.tech_challenge_fase1.service;

import java.util.ArrayList;
import java.util.List;

import br.com.fiap.pos_tech_adj.tech_challenge_fase1.controller.exception.ControllerDatabaseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.fiap.pos_tech_adj.tech_challenge_fase1.controller.exception.ControllerNotFoundException;
import br.com.fiap.pos_tech_adj.tech_challenge_fase1.dto.IndicacaoDTO;
import br.com.fiap.pos_tech_adj.tech_challenge_fase1.entities.Indicacao;
import br.com.fiap.pos_tech_adj.tech_challenge_fase1.repository.IndicacaoRepository;
import jakarta.persistence.EntityNotFoundException;

@Service
public class IndicacaoService {

    private final IndicacaoRepository indicacaoRepository;

    @Autowired
    private EmailService emailService;

    @Autowired
    public IndicacaoService(IndicacaoRepository indicacaoRepository) {
        this.indicacaoRepository = indicacaoRepository;
    }

    public Page<IndicacaoDTO> findAll(Pageable pageable) {
        Page<Indicacao> indicacoes = indicacaoRepository.findAll(pageable);
        return indicacoes.map(this::toDTO);
    }

    public IndicacaoDTO findById(Long id) {
        Indicacao indicacao = indicacaoRepository.findById(id)
                .orElseThrow(() -> new ControllerNotFoundException("Indicação não encontrada"));
        return toDTO(indicacao);
    }

    public IndicacaoDTO save(IndicacaoDTO IndicacaoDTO) {
        try {
            Indicacao indicacao = indicacaoRepository.save(toEntity(IndicacaoDTO));
            return toDTO(indicacao);
        }
        catch (EntityNotFoundException e) {
            throw new ControllerNotFoundException("Entidade não encontrada");
        }catch (DataIntegrityViolationException e){
            throw new ControllerDatabaseException("Erro no database causado por: " + e.getMessage());
        }
    }

    public IndicacaoDTO update(Long id, IndicacaoDTO indicacaoDTO) {
        try {
            Indicacao indicacao = indicacaoRepository.getReferenceById(id);

            indicacao.setVaga(indicacaoDTO.vaga());
            indicacao.setColaborador(indicacaoDTO.colaborador());
            indicacao.setTelefoneCandidato(indicacaoDTO.telefoneCandidato());
            indicacao.setEmailCandidato(indicacaoDTO.emailCandidato());
            indicacao.setCurriculoCandidato(indicacaoDTO.curriculoCandidato());
            indicacao.setPerfilCandidato(indicacaoDTO.perfilCandidato());
            indicacao.setObservacoes(indicacaoDTO.observacoes());

            if (indicacao.isValidado() != indicacaoDTO.validado()){

                indicacao.setValidado(indicacaoDTO.validado());

                if (indicacaoDTO.validado()) {
                    emailService.sendEmail(indicacao.getColaborador().getPessoa().getEmail(),
                            "Indicação",
                            "Sua Indicação referente a Vaga: " + indicacao.getVaga().getTitulo() +
                                    " Foi validada.");
                }else {
                    emailService.sendEmail(indicacao.getColaborador().getPessoa().getEmail(),
                            "Indicação",
                            "Sua Indicação referente a Vaga: " + indicacao.getVaga().getTitulo() +
                                    " Não foi validada.");
                }
            }

            indicacao = indicacaoRepository.save(indicacao);
            return toDTO(indicacao);
        } catch (EntityNotFoundException e) {
            throw new ControllerNotFoundException("Indicação não encontrada");
        }catch (DataIntegrityViolationException e){
            throw new ControllerDatabaseException("Erro no database causado por: " + e.getMessage());
        }
    }

    public void delete(Long id) {
        indicacaoRepository.deleteById(id);
    }

    private IndicacaoDTO toDTO(Indicacao indicacao) {
        return new IndicacaoDTO(
                indicacao.getId(),
                indicacao.getVaga(),
                indicacao.getColaborador(),
                indicacao.getTelefoneCandidato(),
                indicacao.getEmailCandidato(),
                indicacao.getCurriculoCandidato(),
                indicacao.getPerfilCandidato(),
                indicacao.getObservacoes(),
                indicacao.isValidado());
    }

    private Indicacao toEntity(IndicacaoDTO indicacaoDTO) {
        return new Indicacao(
                indicacaoDTO.id(),
                indicacaoDTO.vaga(),
                indicacaoDTO.colaborador(),
                indicacaoDTO.telefoneCandidato(),
                indicacaoDTO.emailCandidato(),
                indicacaoDTO.curriculoCandidato(),
                indicacaoDTO.perfilCandidato(),
                indicacaoDTO.observacoes(),
                indicacaoDTO.validado());
    }
}
