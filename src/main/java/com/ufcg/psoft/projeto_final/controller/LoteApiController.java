package com.ufcg.psoft.projeto_final.controller;

import com.ufcg.psoft.projeto_final.DTOs.LoteDTO;
import com.ufcg.psoft.projeto_final.entidades.Lote;
import com.ufcg.psoft.projeto_final.erro.LoteCadastroInvalido;
import com.ufcg.psoft.projeto_final.erro.LoteNaoEncontrado;
import com.ufcg.psoft.projeto_final.services.LoteService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class LoteApiController {

    @Autowired
    LoteService loteService;

    @PreAuthorize("hasRole('ROLE_FUNCIONARIO')")
    @PostMapping("/lote")
    public ResponseEntity<Lote> addLote(@RequestBody LoteDTO loteDTO) throws Exception { //TODO passei meia hora tentando solucionar isso, ta chiando pra deixar com Exception, wtf
        Lote novoLote = loteService.saveLote(loteDTO);
        return new ResponseEntity<Lote>(novoLote, HttpStatus.CREATED);
    }
    
    @PreAuthorize("hasRole('ROLE_ADMIN') OR hasRole('ROLE_FUNCIONARIO')")
    @GetMapping("/lote/{id}")
    public ResponseEntity<Lote> getLoteById(@RequestParam Long id) throws Exception {
        Lote vacinaEncontrada = loteService.getLoteById(id);
        return new ResponseEntity<Lote>(vacinaEncontrada, HttpStatus.OK);
    }
    
    @PreAuthorize("hasRole('ROLE_ADMIN') OR hasRole('ROLE_FUNCIONARIO')")
    @GetMapping("/lote")
    public ResponseEntity<List<Lote>> getAllLoteVacina() {
        List<Lote> todosOsLotes = loteService.getLote();
        return new ResponseEntity<List<Lote>>(todosOsLotes, HttpStatus.OK);
    }
}
