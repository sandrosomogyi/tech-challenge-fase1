package br.com.fiap.pos_tech_adj.tech_challenge_fase1.controller;

import br.com.fiap.pos_tech_adj.tech_challenge_fase1.dto.BonificacaoDTO;
import br.com.fiap.pos_tech_adj.tech_challenge_fase1.service.BonificacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/bonificacao")
public class BonificacaoController {

    private BonificacaoService bonificacaoService;

    @Autowired
    public BonificacaoController (BonificacaoService bonificacaoService){
        this.bonificacaoService = bonificacaoService;
    }

    @GetMapping
    public ResponseEntity<Page<BonificacaoDTO>> findAll(
            @PageableDefault(size = 10, page = 0, sort = "dataBonificacao")Pageable pageable
            ) {
        Page<BonificacaoDTO> bonificacaoDTOS = bonificacaoService.findAll(pageable);
        return ResponseEntity.ok(bonificacaoDTOS);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BonificacaoDTO> findById (@PathVariable Long id){
        BonificacaoDTO bonificacaoDTO = bonificacaoService.findById(id);
        return ResponseEntity.ok(bonificacaoDTO);
    }

    @PostMapping
    public ResponseEntity<BonificacaoDTO> save(@RequestBody BonificacaoDTO bonificacaoDTO){
        BonificacaoDTO savedBonificacao = bonificacaoService.save(bonificacaoDTO);
        return new ResponseEntity<>(savedBonificacao, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public  ResponseEntity<BonificacaoDTO> update(@PathVariable Long id, @RequestBody BonificacaoDTO bonificacaoDTO){
        BonificacaoDTO updatedBonificacao = bonificacaoService.update(id, bonificacaoDTO);
        return ResponseEntity.ok(updatedBonificacao);
    }

    @DeleteMapping("/{id}")
    public  ResponseEntity<Void> delete(@PathVariable Long id){
        bonificacaoService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
