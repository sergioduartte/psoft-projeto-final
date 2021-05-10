package com.ufcg.psoft.projeto_final.controller;

import com.ufcg.psoft.projeto_final.DTOs.LoteDTO;
import com.ufcg.psoft.projeto_final.entidades.Lote;
import com.ufcg.psoft.projeto_final.services.LoteService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin

public class LoteApiController {

    @Autowired
    LoteService loteService;

    @PreAuthorize("hasRole('ROLE_FUNCIONARIO')")
    @PostMapping("/api/lote")
    public ResponseEntity<Lote> criarLote(@RequestBody LoteDTO loteDTO) throws Exception{
        Lote novoLote = loteService.cadastrarLote(loteDTO);
        return new ResponseEntity<Lote>(novoLote, HttpStatus.CREATED);
    }
    
    @PreAuthorize("hasRole('ROLE_ADMIN') OR hasRole('ROLE_FUNCIONARIO')")
    @GetMapping("/api/lote/{id}")
    public ResponseEntity<Lote> getLoteById(@RequestParam Long id) throws Exception{
        Lote vacinaEncontrada = loteService.getLoteById(id);
        return new ResponseEntity<Lote>(vacinaEncontrada, HttpStatus.OK);
    }
    
    @PreAuthorize("hasRole('ROLE_ADMIN') OR hasRole('ROLE_FUNCIONARIO')")
    @GetMapping("/api/lote")
    public ResponseEntity<List<Lote>> getAllLoteVacina() {
        List<Lote> todosOsLotes = loteService.allLotes();
        return new ResponseEntity<List<Lote>>(todosOsLotes, HttpStatus.OK);
    }
}
