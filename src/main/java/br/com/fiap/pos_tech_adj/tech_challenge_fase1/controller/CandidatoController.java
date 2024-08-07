package br.com.fiap.pos_tech_adj.tech_challenge_fase1.controller;

import br.com.fiap.pos_tech_adj.tech_challenge_fase1.dto.CandidatoDTO;
import br.com.fiap.pos_tech_adj.tech_challenge_fase1.service.CandidatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/candidato")
public class CandidatoController {

    private CandidatoService candidatoService;

    @Autowired
    public CandidatoController (CandidatoService candidatoService){
        this.candidatoService = candidatoService;
    }

    @GetMapping
    public ResponseEntity<Page<CandidatoDTO>> findAll(
            @PageableDefault(size = 10, page = 0, sort = "id")Pageable pageable
    ) {
        Page<CandidatoDTO> candidatoDTOS = candidatoService.findAll(pageable);
        return ResponseEntity.ok(candidatoDTOS);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CandidatoDTO> findById (@PathVariable Long id){
        CandidatoDTO candidatoDTO = candidatoService.findById(id);
        return ResponseEntity.ok(candidatoDTO);
    }

    @PostMapping
    public ResponseEntity<CandidatoDTO> save(@RequestBody CandidatoDTO candidatoDTO){
        CandidatoDTO savedCandidato = candidatoService.save(candidatoDTO);
        return new ResponseEntity<>(savedCandidato, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public  ResponseEntity<CandidatoDTO> update(@PathVariable Long id, @RequestBody CandidatoDTO candidatoDTO){
        CandidatoDTO updatedCandidato = candidatoService.update(id, candidatoDTO);
        return ResponseEntity.ok(updatedCandidato);
    }

    @DeleteMapping("/{id}")
    public  ResponseEntity<Void> delete(@PathVariable Long id){
        candidatoService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
