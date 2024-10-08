package br.com.fiap.pos_tech_adj.tech_challenge_fase1.service;

import br.com.fiap.pos_tech_adj.tech_challenge_fase1.controller.exception.ControllerDatabaseException;
import br.com.fiap.pos_tech_adj.tech_challenge_fase1.controller.exception.ControllerNotFoundException;
import br.com.fiap.pos_tech_adj.tech_challenge_fase1.dto.ContratacaoDTO;
import br.com.fiap.pos_tech_adj.tech_challenge_fase1.entities.Contratacao;
import br.com.fiap.pos_tech_adj.tech_challenge_fase1.repository.ContratacaoRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ContratacaoService {

    private final ContratacaoRepository contratacaoRepository;

    @Autowired
    private EmailService emailService;

    @Autowired
    public ContratacaoService (ContratacaoRepository contratacaoRepository){
        this.contratacaoRepository = contratacaoRepository;
    }

    public Page<ContratacaoDTO> findAll (Pageable pageable){
        Page<Contratacao> contratacoes = contratacaoRepository.findAll(pageable);
        return contratacoes.map(this::toDTO);
    }

    public ContratacaoDTO findById(Long id){
        Contratacao contratacao = contratacaoRepository.findById(id)
                .orElseThrow(() -> new ControllerNotFoundException("Contratação não encontrada"));
        return toDTO(contratacao);
    }

    public ContratacaoDTO save(ContratacaoDTO contratacaoDTO){
        try {
            Contratacao contratacao = contratacaoRepository.save(toEntity(contratacaoDTO));

            return toDTO(contratacao);
        }
        catch (EntityNotFoundException e){
            throw new ControllerNotFoundException("Entidade não encontrada");
        }catch (DataIntegrityViolationException e){
            throw new ControllerDatabaseException("Erro no database causado por: " + e.getMessage());
        }
    }

    public ContratacaoDTO update(Long id, ContratacaoDTO contratacaoDTO){
        try{
            Contratacao contratacao = contratacaoRepository.getReferenceById(id);

            contratacao.setVaga(contratacaoDTO.vaga());
            contratacao.setColaborador(contratacaoDTO.colaborador());
            contratacao.setCandidato(contratacaoDTO.candidato());
            contratacao.setDataInicio(contratacaoDTO.dataInicio());
            contratacao.setDataFim(contratacaoDTO.dataFim());

            if (contratacao.isValidado() != contratacaoDTO.validado()){

                contratacao.setValidado(contratacaoDTO.validado());

                if (contratacaoDTO.validado()) {
                    emailService.sendEmail(contratacao.getColaborador().getPessoa().getEmail(),
                            "Contratação",
                            "Sua Indicação referente a Vaga: " + contratacao.getVaga().getTitulo() +
                                    " Atendeu as regras para bonificação e você será notificado em breve com mais informações.");
                }else {
                    emailService.sendEmail(contratacao.getColaborador().getPessoa().getEmail(),
                            "Contratação",
                            "Sua Indicação referente a Vaga: " + contratacao.getVaga().getTitulo() +
                                    " Não atendeu as regras para bonificação.");
                }
            }

            contratacao = contratacaoRepository.save(contratacao);
            return toDTO(contratacao);
        }
        catch (EntityNotFoundException e){
            throw new ControllerNotFoundException("Contratação não encontrada");
        }catch (DataIntegrityViolationException e){
            throw new ControllerDatabaseException("Erro no database causado por: " + e.getMessage());
        }
    }

    public void delete(Long id){
        contratacaoRepository.deleteById(id);
    }

    private ContratacaoDTO toDTO(Contratacao contratacao) {
        return new ContratacaoDTO(
                contratacao.getId(),
                contratacao.getVaga(),
                contratacao.getColaborador(),
                contratacao.getCandidato(),
                contratacao.getDataInicio(),
                contratacao.getDataFim(),
                contratacao.isValidado()
        );
    }

    private Contratacao toEntity(ContratacaoDTO contratacaoDTO) {
        return new Contratacao(
                contratacaoDTO.id(),
                contratacaoDTO.vaga(),
                contratacaoDTO.colaborador(),
                contratacaoDTO.candidato(),
                contratacaoDTO.dataInicio(),
                contratacaoDTO.dataFim(),
                contratacaoDTO.validado()
        );
    }
}
