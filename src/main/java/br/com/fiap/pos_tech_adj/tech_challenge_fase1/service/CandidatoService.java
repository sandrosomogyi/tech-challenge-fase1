package br.com.fiap.pos_tech_adj.tech_challenge_fase1.service;

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
                .orElseThrow(() -> new RuntimeException("Candidato não Encontrado"));
        return toDTO(candidato);
    }

    public CandidatoDTO save(CandidatoDTO candidatoDTO){
        Candidato candidato = candidatoRepository.save(toEntity(candidatoDTO));
        return toDTO(candidato);
    }

    public CandidatoDTO update(Long id, CandidatoDTO candidatoDTO){
        try{
            Candidato candidato = candidatoRepository.getReferenceById(id);

            candidato.setNome(candidatoDTO.pessoaDTO().nome());
            candidato.setSobrenome(candidatoDTO.pessoaDTO().sobrenome());
            candidato.setTelefone(candidatoDTO.pessoaDTO().telefone());
            candidato.setEmail(candidatoDTO.pessoaDTO().email());
            candidato.setPerfilLinkedin(candidatoDTO.perfilLinkedin());
            candidato.setCurriculo(candidatoDTO.curriculo());

            candidato = candidatoRepository.save(candidato);
            return toDTO(candidato);
        }
        catch (EntityNotFoundException e){
            throw new RuntimeException("Candidato não Encontrado");
        }
    }

    public void delete(Long id){
        candidatoRepository.deleteById(id);
    }

    private CandidatoDTO toDTO(Candidato candidato) {
        PessoaDTO pessoaDTO = new PessoaDTO(
                candidato.getNome(),
                candidato.getSobrenome(),
                candidato.getTelefone(),
                candidato.getEmail()
        );

        return new CandidatoDTO(
                candidato.getIdCandidato(),
                pessoaDTO,
                candidato.getPerfilLinkedin(),
                candidato.getCurriculo()
        );
    }

    private Candidato toEntity(CandidatoDTO candidatoDTO) {
        return new Candidato(
                candidatoDTO.idCandidato(),
                candidatoDTO.pessoaDTO().nome(),
                candidatoDTO.pessoaDTO().sobrenome(),
                candidatoDTO.pessoaDTO().telefone(),
                candidatoDTO.pessoaDTO().email(),
                candidatoDTO.perfilLinkedin(),
                candidatoDTO.curriculo()
        );
    }
}
