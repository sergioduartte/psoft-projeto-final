package com.ufcg.psoft.projeto_final.controllers;

import com.ufcg.psoft.projeto_final.DTOs.LoteDTO;
import com.ufcg.psoft.projeto_final.errors.LoteCadastroInvalido;
import com.ufcg.psoft.projeto_final.errors.LoteNaoEncontrado;
import com.ufcg.psoft.projeto_final.models.Lote;
import com.ufcg.psoft.projeto_final.services.lote.LoteService;

import io.swagger.annotations.ApiOperation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class LoteController {

    @Autowired
    LoteService loteService;

    @ApiOperation(value = "Cadastra um lote no sistema")
    @PostMapping("/lote")
    public ResponseEntity<Lote> addLote(@RequestBody LoteDTO loteDTO) throws LoteCadastroInvalido {
        Lote novoLote = loteService.saveLote(loteDTO);
        return new ResponseEntity<Lote>(novoLote, HttpStatus.CREATED);
    }

    @ApiOperation(value = "Retorna lote a partir do seu Id")
    @GetMapping("/lote/{id}")
    public ResponseEntity<Lote> getLoteById(@RequestBody Long id) throws LoteNaoEncontrado {
        Lote vacinaEncontrada = loteService.getLoteById(id);
        return new ResponseEntity<Lote>(vacinaEncontrada, HttpStatus.OK);
    }

    @ApiOperation(value = "Retorna todos os lotes cadastrados no sistema")
    @GetMapping("/lote")
    public ResponseEntity<List<Lote>> getAllLoteVacina() {
        List<Lote> todosOsLotes = loteService.getLote();
        return new ResponseEntity<List<Lote>>(todosOsLotes, HttpStatus.OK);
    }
}
