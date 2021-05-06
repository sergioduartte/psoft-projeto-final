package com.example.projeto_final_psoft.controladores;


import com.example.projeto_final_psoft.entidades.Vacina;
import com.example.projeto_final_psoft.servicos.VacinaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class VacinaApiController {
    private VacinaService vacinaService;

    public VacinaApiController(VacinaService vacinaService) {
        super();
        this.vacinaService = vacinaService;
    }

    @PostMapping("/api/vacina")
    public ResponseEntity<Vacina> adicionaVacina(@RequestParam(value = "nome") String nome) {
        Vacina vacina = new Vacina(nome);
        return new ResponseEntity<Vacina>(vacinaService.adicionaVacina(vacina), HttpStatus.CREATED);
    }

    @GetMapping("/api/vacina/{id}")
    public ResponseEntity<Vacina> getVacina(@PathVariable Long id) {
        Optional<Vacina> vacina = vacinaService.getVacina(id);
        if (vacina.isPresent())
            return new ResponseEntity<Vacina>(vacina.get(), HttpStatus.OK);
        return new ResponseEntity<Vacina>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/api/vacina")
    public ResponseEntity<List<Vacina>> getVacina() {
        return new ResponseEntity<List<Vacina>>(vacinaService.getVacina(), HttpStatus.OK);
    }
}
