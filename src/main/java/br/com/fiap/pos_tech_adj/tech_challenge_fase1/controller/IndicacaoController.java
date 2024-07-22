package br.com.fiap.pos_tech_adj.tech_challenge_fase1.controller;

import br.com.fiap.pos_tech_adj.tech_challenge_fase1.dto.IndicacaoDTO;
import br.com.fiap.pos_tech_adj.tech_challenge_fase1.service.IndicacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/indicacao")
public class IndicacaoController {

    private IndicacaoService indicacaoService;

    @Autowired
    public IndicacaoController (IndicacaoService indicacaoService){
        this.indicacaoService = indicacaoService;
    }

    @GetMapping
    public ResponseEntity<Page<IndicacaoDTO>> findAll(
            @PageableDefault(size = 10, page = 0, sort = "validado")Pageable pageable
    ) {
        Page<IndicacaoDTO> indicacaoDTOS = indicacaoService.findAll(pageable);
        return ResponseEntity.ok(indicacaoDTOS);
    }

    @GetMapping("/{id}")
    public ResponseEntity<IndicacaoDTO> findById (@PathVariable Long id){
        IndicacaoDTO indicacaoDTO = indicacaoService.findById(id);
        return ResponseEntity.ok(indicacaoDTO);
    }

    @PostMapping
    public ResponseEntity<IndicacaoDTO> save(@RequestBody IndicacaoDTO indicacaoDTO){
        IndicacaoDTO savedIndicacao = indicacaoService.save(indicacaoDTO);
        return new ResponseEntity<>(savedIndicacao, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public  ResponseEntity<IndicacaoDTO> update(@PathVariable Long id, @RequestBody IndicacaoDTO indicacaoDTO){
        IndicacaoDTO updatedIndicacao = indicacaoService.update(id, indicacaoDTO);
        return ResponseEntity.ok(updatedIndicacao);
    }

    @DeleteMapping("/{id}")
    public  ResponseEntity<Void> delete(@PathVariable Long id){
        indicacaoService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
