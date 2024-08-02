package br.com.fiap.pos_tech_adj.tech_challenge_fase1.service;

import br.com.fiap.pos_tech_adj.tech_challenge_fase1.controller.exception.ControllerDatabaseException;
import br.com.fiap.pos_tech_adj.tech_challenge_fase1.controller.exception.ControllerNotFoundException;
import br.com.fiap.pos_tech_adj.tech_challenge_fase1.dto.ColaboradorDTO;
import br.com.fiap.pos_tech_adj.tech_challenge_fase1.entities.Colaborador;
import br.com.fiap.pos_tech_adj.tech_challenge_fase1.repository.ColaboradorRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ColaboradorService {

    private final ColaboradorRepository colaboradorRepository;

    @Autowired
    public ColaboradorService(ColaboradorRepository colaboradorRepository) {
        this.colaboradorRepository = colaboradorRepository;
    }

    public Page<ColaboradorDTO> findAll(Pageable pageable) {
        Page<Colaborador> colaboradores = colaboradorRepository.findAll(pageable);
        return colaboradores.map(this::toDTO);
    }

    public ColaboradorDTO findById(Long id) {
        Colaborador colaborador = colaboradorRepository.findById(id)
                .orElseThrow(() -> new ControllerNotFoundException("Colaborador não encontrado"));
        return toDTO(colaborador);
    }

    public ColaboradorDTO save(ColaboradorDTO colaboradorDTO) {
        try {
            Colaborador colaborador = colaboradorRepository.save(toEntity(colaboradorDTO));
            return toDTO(colaborador);
        }catch (EntityNotFoundException e) {
            throw new ControllerNotFoundException("Entidade não encontrada");
        }catch (DataIntegrityViolationException e){
            throw new ControllerDatabaseException("Erro no database causado por: " + e.getMessage());
        }
    }

    public ColaboradorDTO update(Long id, ColaboradorDTO colaboradorDTO) {
        try {
            Colaborador colaborador = colaboradorRepository.getReferenceById(id);

            colaborador.setDepartamento(colaboradorDTO.departamento());
            colaborador.setCargo(colaboradorDTO.cargo());
            colaborador.setDataContratacao(colaboradorDTO.dataContratacao());
            colaborador.setPessoa(colaboradorDTO.pessoa());

            colaborador = colaboradorRepository.save(colaborador);
            return toDTO(colaborador);
        } catch (EntityNotFoundException e) {
            throw new ControllerNotFoundException("Colaborador não encontrado");
        }catch (DataIntegrityViolationException e){
            throw new ControllerDatabaseException("Erro no database causado por: " + e.getMessage());
        }
    }

    public void delete(Long id) {
        colaboradorRepository.deleteById(id);
    }

    private ColaboradorDTO toDTO(Colaborador colaborador) {
        return new ColaboradorDTO(
                colaborador.getId(),
                colaborador.getDepartamento(),
                colaborador.getCargo(),
                colaborador.getDataContratacao(),
                colaborador.getPessoa(),
                colaborador.getIndicacoes(),
                colaborador.getBonificacoes()
        );
    }

    private Colaborador toEntity(ColaboradorDTO colaboradorDTO) {
        return new Colaborador(
                colaboradorDTO.id(),
                colaboradorDTO.departamento(),
                colaboradorDTO.cargo(),
                colaboradorDTO.dataContratacao(),
                colaboradorDTO.pessoa(),
                colaboradorDTO.indicacoes(),
                colaboradorDTO.bonificacoes()
        );
    }
}
