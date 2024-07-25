package br.com.fiap.pos_tech_adj.tech_challenge_fase1.service;

import br.com.fiap.pos_tech_adj.tech_challenge_fase1.controller.exception.ControllerNotFoundException;
import br.com.fiap.pos_tech_adj.tech_challenge_fase1.dto.PessoaDTO;
import br.com.fiap.pos_tech_adj.tech_challenge_fase1.entities.Pessoa;
import br.com.fiap.pos_tech_adj.tech_challenge_fase1.repository.PessoaRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class PessoaService {

    private final PessoaRepository pessoaRepository;

    @Autowired
    public PessoaService (PessoaRepository pessoaRepository){
        this.pessoaRepository = pessoaRepository;
    }

    public Page<PessoaDTO> findAll (Pageable pageable){
        Page<Pessoa> pessoas = pessoaRepository.findAll(pageable);
        return pessoas.map(this::toDTO);
    }

    public PessoaDTO findById(Long id){
        Pessoa Pessoa = pessoaRepository.findById(id)
                .orElseThrow(() -> new ControllerNotFoundException("Pessoa não encontrada"));
        return toDTO(Pessoa);
    }

    public PessoaDTO save(PessoaDTO pessoaDTO){
        Pessoa pessoa = pessoaRepository.save(toEntity(pessoaDTO));
        return toDTO(pessoa);
    }

    public PessoaDTO update(Long id, PessoaDTO pessoaDTO){
        try{
            Pessoa pessoa = pessoaRepository.getReferenceById(id);

            pessoa.setNome(pessoaDTO.nome());
            pessoa.setSobrenome(pessoaDTO.sobrenome());
            pessoa.setTelefone(pessoaDTO.telefone());
            pessoa.setEmail(pessoaDTO.email());

            pessoa = pessoaRepository.save(pessoa);
            return toDTO(pessoa);
        }
        catch (EntityNotFoundException e){
            throw new ControllerNotFoundException("Pessoa não encontrada");
        }
    }

    public void delete(Long id){
        pessoaRepository.deleteById(id);
    }

    private PessoaDTO toDTO(Pessoa pessoa) {
        return new PessoaDTO(
                pessoa.getIdPessoa(),
                pessoa.getNome(),
                pessoa.getSobrenome(),
                pessoa.getTelefone(),
                pessoa.getEmail()
        );
    }

    private Pessoa toEntity(PessoaDTO pessoaDTO) {
        return new Pessoa(
                pessoaDTO.idPessoa(),
                pessoaDTO.nome(),
                pessoaDTO.sobrenome(),
                pessoaDTO.telefone(),
                pessoaDTO.email()
        );
    }
}
