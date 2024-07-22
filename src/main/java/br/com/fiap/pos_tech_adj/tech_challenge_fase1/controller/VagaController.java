package br.com.fiap.pos_tech_adj.tech_challenge_fase1.controller;

import br.com.fiap.pos_tech_adj.tech_challenge_fase1.dto.VagaDTO;
import br.com.fiap.pos_tech_adj.tech_challenge_fase1.service.VagaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/vaga")
public class VagaController {

    private VagaService vagaService;

    @Autowired
    public VagaController (VagaService vagaService){
        this.vagaService = vagaService;
    }

    @GetMapping
    public ResponseEntity<Page<VagaDTO>> findAll(
            @PageableDefault(size = 10, page = 0, sort = "titulo")Pageable pageable
    ) {
        Page<VagaDTO> vagaDTOS = vagaService.findAll(pageable);
        return ResponseEntity.ok(vagaDTOS);
    }

    @GetMapping("/{id}")
    public ResponseEntity<VagaDTO> findById (@PathVariable Long id){
        VagaDTO vagaDTO = vagaService.findById(id);
        return ResponseEntity.ok(vagaDTO);
    }

    @PostMapping
    public ResponseEntity<VagaDTO> save(@RequestBody VagaDTO vagaDTO){
        VagaDTO savedVaga = vagaService.save(vagaDTO);
        return new ResponseEntity<>(savedVaga, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public  ResponseEntity<VagaDTO> update(@PathVariable Long id, @RequestBody VagaDTO vagaDTO){
        VagaDTO updatedVaga = vagaService.update(id, vagaDTO);
        return ResponseEntity.ok(updatedVaga);
    }

    @DeleteMapping("/{id}")
    public  ResponseEntity<Void> delete(@PathVariable Long id){
        vagaService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
