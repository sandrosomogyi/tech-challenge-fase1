package br.com.fiap.pos_tech_adj.tech_challenge_fase1.controller;

import br.com.fiap.pos_tech_adj.tech_challenge_fase1.dto.ColaboradorDTO;
import br.com.fiap.pos_tech_adj.tech_challenge_fase1.service.ColaboradorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/colaborador")
public class ColaboradorController {

    private ColaboradorService colaboradorService;

    @Autowired
    public ColaboradorController (ColaboradorService colaboradorService){
        this.colaboradorService = colaboradorService;
    }

    @GetMapping
    public ResponseEntity<Page<ColaboradorDTO>> findAll(
            @PageableDefault(size = 10, page = 0, sort = "idColaborador")Pageable pageable
    ) {
        Page<ColaboradorDTO> colaboradorDTOS = colaboradorService.findAll(pageable);
        return ResponseEntity.ok(colaboradorDTOS);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ColaboradorDTO> findById (@PathVariable Long id){
        ColaboradorDTO colaboradorDTO = colaboradorService.findById(id);
        return ResponseEntity.ok(colaboradorDTO);
    }

    @PostMapping
    public ResponseEntity<ColaboradorDTO> save(@RequestBody ColaboradorDTO colaboradorDTO){
        ColaboradorDTO savedColaborador = colaboradorService.save(colaboradorDTO);
        return new ResponseEntity<>(savedColaborador, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public  ResponseEntity<ColaboradorDTO> update(@PathVariable Long id, @RequestBody ColaboradorDTO colaboradorDTO){
        ColaboradorDTO updatedColaborador = colaboradorService.update(id, colaboradorDTO);
        return ResponseEntity.ok(updatedColaborador);
    }

    @DeleteMapping("/{id}")
    public  ResponseEntity<Void> delete(@PathVariable Long id){
        colaboradorService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
