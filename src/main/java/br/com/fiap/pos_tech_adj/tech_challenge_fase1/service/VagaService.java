package br.com.fiap.pos_tech_adj.tech_challenge_fase1.service;

import br.com.fiap.pos_tech_adj.tech_challenge_fase1.dto.VagaDTO;
import br.com.fiap.pos_tech_adj.tech_challenge_fase1.entities.Vaga;
import br.com.fiap.pos_tech_adj.tech_challenge_fase1.repository.VagaRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class VagaService {

    private final VagaRepository vagaRepository;

    @Autowired
    public VagaService (VagaRepository vagaRepository){
        this.vagaRepository = vagaRepository;
    }

    public Page<VagaDTO> findAll (Pageable pageable){
        Page<Vaga> vagas = vagaRepository.findAll(pageable);
        return vagas.map(this::toDTO);
    }

    public VagaDTO findById(Long id){
        Vaga vaga = vagaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Vaga não Encontrada"));
        return toDTO(vaga);
    }

    public VagaDTO save(VagaDTO vagaDTO){
        Vaga vaga = vagaRepository.save(toEntity(vagaDTO));
        return toDTO(vaga);
    }

    public VagaDTO update(Long id, VagaDTO vagaDTO){
        try{
            Vaga vaga = vagaRepository.getReferenceById(id);

            vaga.setTitulo(vagaDTO.titulo());
            vaga.setDescricao(vagaDTO.descricao());
            vaga.setRequisitosObrigatorios(vagaDTO.requisitosObrigatorios());
            vaga.setRequisitosDesejaveis(vagaDTO.requisitosDesejaveis());
            vaga.setBeneficios(vagaDTO.beneficios());
            vaga.setTipoContratacao(vagaDTO.tipoContratacao());
            vaga.setRemuneracao(vagaDTO.remuneracao());
            vaga.setValorBonificacao(vagaDTO.valorBonificacao());
            vaga.setObservacoes(vagaDTO.observacoes());

            vaga = vagaRepository.save(vaga);
            return toDTO(vaga);
        }
        catch (EntityNotFoundException e){
            throw new RuntimeException("Vaga não Encontrada");
        }
    }

    public void delete(Long id){
        vagaRepository.deleteById(id);
    }

    private VagaDTO toDTO(Vaga vaga) {
        return new VagaDTO(
                vaga.getIdVaga(),
                vaga.getTitulo(),
                vaga.getDescricao(),
                vaga.getRequisitosObrigatorios(),
                vaga.getRequisitosDesejaveis(),
                vaga.getBeneficios(),
                vaga.getTipoContratacao(),
                vaga.getRemuneracao(),
                vaga.getValorBonificacao(),
                vaga.getObservacoes()
        );
    }

    private Vaga toEntity(VagaDTO vagaDTO) {
        return new Vaga(
                vagaDTO.idVaga(),
                vagaDTO.titulo(),
                vagaDTO.descricao(),
                vagaDTO.requisitosObrigatorios(),
                vagaDTO.requisitosDesejaveis(),
                vagaDTO.beneficios(),
                vagaDTO.tipoContratacao(),
                vagaDTO.remuneracao(),
                vagaDTO.valorBonificacao(),
                vagaDTO.observacoes()
        );
    }
}
