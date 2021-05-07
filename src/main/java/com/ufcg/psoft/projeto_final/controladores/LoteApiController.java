package com.ufcg.psoft.projeto_final.controladores;

import com.ufcg.psoft.projeto_final.DTOs.LoteDTO;
import com.ufcg.psoft.projeto_final.entidades.Lote;
import com.ufcg.psoft.projeto_final.servicos.LoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin

public class LoteApiController {

    @Autowired
    LoteService loteService;

    @PostMapping("/api/lote")
    public ResponseEntity<Lote> criarLote(@RequestBody LoteDTO loteDTO) throws Exception{
        Lote novoLote = loteService.cadastrarLote(loteDTO);
        return new ResponseEntity<Lote>(novoLote, HttpStatus.CREATED);
    }
    @GetMapping("/api/lote/{id}")
    public ResponseEntity<Lote> getLoteById(@RequestParam Long id) throws Exception{
        Lote vacinaEncontrada = loteService.getLoteById(id);
        return new ResponseEntity<Lote>(vacinaEncontrada, HttpStatus.OK);
    }
    @GetMapping("/api/lote")
    public ResponseEntity<List<Lote>> getAllLoteVacina() {
        List<Lote> todosOsLotes = loteService.allLotes();
        return new ResponseEntity<List<Lote>>(todosOsLotes, HttpStatus.OK);
    }
}
