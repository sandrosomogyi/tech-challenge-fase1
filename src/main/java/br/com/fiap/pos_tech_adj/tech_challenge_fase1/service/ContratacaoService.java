package br.com.fiap.pos_tech_adj.tech_challenge_fase1.service;

import br.com.fiap.pos_tech_adj.tech_challenge_fase1.controller.exception.ControllerNotFoundException;
import br.com.fiap.pos_tech_adj.tech_challenge_fase1.dto.ContratacaoDTO;
import br.com.fiap.pos_tech_adj.tech_challenge_fase1.entities.Contratacao;
import br.com.fiap.pos_tech_adj.tech_challenge_fase1.repository.ContratacaoRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ContratacaoService {

    private final ContratacaoRepository contratacaoRepository;

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
        Contratacao contratacao = contratacaoRepository.save(toEntity(contratacaoDTO));
        return toDTO(contratacao);
    }

    public ContratacaoDTO update(Long id, ContratacaoDTO contratacaoDTO){
        try{
            Contratacao contratacao = contratacaoRepository.getReferenceById(id);

            contratacao.setVaga(contratacaoDTO.vaga());
            contratacao.setColaborador(contratacaoDTO.colaborador());
            contratacao.setCandidato(contratacaoDTO.candidato());
            contratacao.setDataInicio(contratacaoDTO.dataInicio());
            contratacao.setDataFim(contratacaoDTO.dataFim());
            contratacao.setValidado(contratacaoDTO.validado());

            contratacao = contratacaoRepository.save(contratacao);
            return toDTO(contratacao);
        }
        catch (EntityNotFoundException e){
            throw new ControllerNotFoundException("Contratação não encontrada");
        }
    }

    public void delete(Long id){
        contratacaoRepository.deleteById(id);
    }

    private ContratacaoDTO toDTO(Contratacao contratacao) {
        return new ContratacaoDTO(
                contratacao.getIdContratacao(),
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
                contratacaoDTO.idContratacao(),
                contratacaoDTO.vaga(),
                contratacaoDTO.colaborador(),
                contratacaoDTO.candidato(),
                contratacaoDTO.dataInicio(),
                contratacaoDTO.dataFim(),
                contratacaoDTO.validado()
        );
    }
}
