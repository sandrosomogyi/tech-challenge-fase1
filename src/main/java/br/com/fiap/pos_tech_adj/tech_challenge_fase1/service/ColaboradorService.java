package br.com.fiap.pos_tech_adj.tech_challenge_fase1.service;

import br.com.fiap.pos_tech_adj.tech_challenge_fase1.dto.ColaboradorDTO;
import br.com.fiap.pos_tech_adj.tech_challenge_fase1.dto.PessoaDTO;
import br.com.fiap.pos_tech_adj.tech_challenge_fase1.entities.Colaborador;
import br.com.fiap.pos_tech_adj.tech_challenge_fase1.repository.ColaboradorRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ColaboradorService {

    private final ColaboradorRepository colaboradorRepository;

    @Autowired
    public ColaboradorService (ColaboradorRepository colaboradorRepository){
        this.colaboradorRepository = colaboradorRepository;
    }

    public Page<ColaboradorDTO> findAll (Pageable pageable){
        Page<Colaborador> colaboradores = colaboradorRepository.findAll(pageable);
        return colaboradores.map(this::toDTO);
    }

    public ColaboradorDTO findById(Long id){
        Colaborador colaborador = colaboradorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Colaborador não Encontrado"));
        return toDTO(colaborador);
    }

    public ColaboradorDTO save(ColaboradorDTO colaboradorDTO){
        Colaborador colaborador = colaboradorRepository.save(toEntity(colaboradorDTO));
        return toDTO(colaborador);
    }

    public ColaboradorDTO update(Long id, ColaboradorDTO colaboradorDTO){
        try{
            Colaborador colaborador = colaboradorRepository.getReferenceById(id);

            colaborador.setNome(colaboradorDTO.pessoaDTO().nome());
            colaborador.setSobrenome(colaboradorDTO.pessoaDTO().sobrenome());
            colaborador.setTelefone(colaboradorDTO.pessoaDTO().telefone());
            colaborador.setEmail(colaboradorDTO.pessoaDTO().email());

            colaborador = colaboradorRepository.save(colaborador);
            return toDTO(colaborador);
        }
        catch (EntityNotFoundException e){
            throw new RuntimeException("Colaborador não Encontrado");
        }
    }

    public void delete(Long id){
        colaboradorRepository.deleteById(id);
    }

    private ColaboradorDTO toDTO(Colaborador colaborador) {
        PessoaDTO pessoaDTO = new PessoaDTO(
                colaborador.getNome(),
                colaborador.getSobrenome(),
                colaborador.getTelefone(),
                colaborador.getEmail()
        );

        return new ColaboradorDTO(
                colaborador.getIdColaborador(),
                pessoaDTO
        );
    }

    private Colaborador toEntity(ColaboradorDTO colaboradorDTO) {
        return new Colaborador(
                colaboradorDTO.idColaborador(),
                colaboradorDTO.pessoaDTO().nome(),
                colaboradorDTO.pessoaDTO().sobrenome(),
                colaboradorDTO.pessoaDTO().telefone(),
                colaboradorDTO.pessoaDTO().email()
        );
    }
}
