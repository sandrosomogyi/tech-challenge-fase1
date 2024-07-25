package br.com.fiap.pos_tech_adj.tech_challenge_fase1.service;

import br.com.fiap.pos_tech_adj.tech_challenge_fase1.controller.exception.ControllerNotFoundException;
import br.com.fiap.pos_tech_adj.tech_challenge_fase1.dto.CandidatoDTO;
import br.com.fiap.pos_tech_adj.tech_challenge_fase1.dto.PessoaDTO;
import br.com.fiap.pos_tech_adj.tech_challenge_fase1.entities.Candidato;
import br.com.fiap.pos_tech_adj.tech_challenge_fase1.repository.CandidatoRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CandidatoService {

    private final CandidatoRepository candidatoRepository;

    @Autowired
    public CandidatoService (CandidatoRepository candidatoRepository){
        this.candidatoRepository = candidatoRepository;
    }

    public Page<CandidatoDTO> findAll (Pageable pageable){
        Page<Candidato> candidatos = candidatoRepository.findAll(pageable);
        return candidatos.map(this::toDTO);
    }

    public CandidatoDTO findById(Long id){
        Candidato candidato = candidatoRepository.findById(id)
                .orElseThrow(() -> new ControllerNotFoundException("Candidato não encontrado"));
        return toDTO(candidato);
    }

    public CandidatoDTO save(CandidatoDTO candidatoDTO){
        Candidato candidato = candidatoRepository.save(toEntity(candidatoDTO));
        return toDTO(candidato);
    }

    public CandidatoDTO update(Long id, CandidatoDTO candidatoDTO){
        try{
            Candidato candidato = candidatoRepository.getReferenceById(id);

            candidato.setPessoa(candidatoDTO.pessoa());
            candidato.setPerfilLinkedin(candidatoDTO.perfilLinkedin());
            candidato.setCurriculo(candidatoDTO.curriculo());

            candidato = candidatoRepository.save(candidato);
            return toDTO(candidato);
        }
        catch (EntityNotFoundException e){
            throw new ControllerNotFoundException("Candidato não encontrado");
        }
    }

    public void delete(Long id){
        candidatoRepository.deleteById(id);
    }

    private CandidatoDTO toDTO(Candidato candidato) {
        return new CandidatoDTO(
                candidato.getIdCandidato(),
                candidato.getPessoa(),
                candidato.getPerfilLinkedin(),
                candidato.getCurriculo()
        );
    }

    private Candidato toEntity(CandidatoDTO candidatoDTO) {
        return new Candidato(
                candidatoDTO.idCandidato(),
                candidatoDTO.pessoa(),
                candidatoDTO.perfilLinkedin(),
                candidatoDTO.curriculo()
        );
    }
}
