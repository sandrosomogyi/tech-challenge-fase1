package br.com.fiap.pos_tech_adj.tech_challenge_fase1.controller;

import br.com.fiap.pos_tech_adj.tech_challenge_fase1.dto.ContratacaoDTO;
import br.com.fiap.pos_tech_adj.tech_challenge_fase1.service.ContratacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/contratacao")
public class ContratacaoController {

    private ContratacaoService contratacaoService;

    @Autowired
    public ContratacaoController (ContratacaoService contratacaoService){
        this.contratacaoService = contratacaoService;
    }

    @GetMapping
    public ResponseEntity<Page<ContratacaoDTO>> findAll(
            @PageableDefault(size = 10, page = 0, sort = "validado")Pageable pageable
    ) {
        Page<ContratacaoDTO> contratacaoDTOS = contratacaoService.findAll(pageable);
        return ResponseEntity.ok(contratacaoDTOS);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ContratacaoDTO> findById (@PathVariable Long id){
        ContratacaoDTO contratacaoDTO = contratacaoService.findById(id);
        return ResponseEntity.ok(contratacaoDTO);
    }

    @PostMapping
    public ResponseEntity<ContratacaoDTO> save(@RequestBody ContratacaoDTO contratacaoDTO){
        ContratacaoDTO savedContratacao = contratacaoService.save(contratacaoDTO);
        return new ResponseEntity<>(savedContratacao, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public  ResponseEntity<ContratacaoDTO> update(@PathVariable Long id, @RequestBody ContratacaoDTO contratacaoDTO){
        ContratacaoDTO updatedContratacao = contratacaoService.update(id, contratacaoDTO);
        return ResponseEntity.ok(updatedContratacao);
    }

    @DeleteMapping("/{id}")
    public  ResponseEntity<Void> delete(@PathVariable Long id){
        contratacaoService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
