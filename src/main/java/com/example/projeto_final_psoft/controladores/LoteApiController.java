package com.example.projeto_final_psoft.controladores;
import com.example.projeto_final_psoft.DTOs.LoteDTO;
import com.example.projeto_final_psoft.entidades.Lote;
import com.example.projeto_final_psoft.servicos.CidadaoService;
import com.example.projeto_final_psoft.servicos.LoteService;
import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
