package com.ufcg.psoft.projeto_final.controllers;

import com.ufcg.psoft.projeto_final.DTOs.LoteDTO;
import com.ufcg.psoft.projeto_final.models.Lote;
import com.ufcg.psoft.projeto_final.services.lote.LoteService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class LoteController {

    @Autowired
    LoteService loteService;

    @PostMapping("/lote")
    public ResponseEntity<Lote> addLote(@RequestBody LoteDTO loteDTO) throws Exception { //TODO passei meia hora tentando solucionar isso, ta chiando pra deixar com Exception, wtf
        Lote novoLote = loteService.saveLote(loteDTO);
        return new ResponseEntity<Lote>(novoLote, HttpStatus.CREATED);
    }

    @GetMapping("/lote/{id}")
    public ResponseEntity<Lote> getLoteById(@RequestBody Long id) throws Exception {
        Lote vacinaEncontrada = loteService.getLoteById(id);
        return new ResponseEntity<Lote>(vacinaEncontrada, HttpStatus.OK);
    }

    @GetMapping("/lote")
    public ResponseEntity<List<Lote>> getAllLoteVacina() {
        List<Lote> todosOsLotes = loteService.getLote();
        return new ResponseEntity<List<Lote>>(todosOsLotes, HttpStatus.OK);
    }
}
