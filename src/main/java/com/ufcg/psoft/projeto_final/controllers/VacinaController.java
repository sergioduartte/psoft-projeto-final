package com.ufcg.psoft.projeto_final.controllers;


import com.ufcg.psoft.projeto_final.DTOs.VacinaDTO;
import com.ufcg.psoft.projeto_final.errors.VacinaCadastroInvalido;
import com.ufcg.psoft.projeto_final.errors.VacinaNaoEncontrada;
import com.ufcg.psoft.projeto_final.models.Vacina;
import com.ufcg.psoft.projeto_final.services.vacina.VacinaService;

import io.swagger.annotations.ApiOperation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class VacinaController {

    @Autowired
    VacinaService vacinaService;

    @ApiOperation(value = "Retorna todas as vacinas cadastradas no sistema")
    @GetMapping("/vacina")
    public ResponseEntity<List<Vacina>> getVacinas() {
        List<Vacina> vacinas = vacinaService.getVacina();
        return new ResponseEntity<List<Vacina>>(vacinas, HttpStatus.OK);
    }
    @ApiOperation(value = "Retorna uma vacina a partir do seu Id")
    @GetMapping("/vacina/{id}")
    public ResponseEntity<Vacina> getVacinaById(@RequestParam Long id) throws VacinaNaoEncontrada {
        Vacina vacina = vacinaService.getVacinaById(id);
        return new ResponseEntity<Vacina>(vacina, HttpStatus.OK);
    }
    @ApiOperation(value = "Cadastra uma vacina no sistema")
    @PostMapping("/vacina")
    public ResponseEntity<Vacina> vacina(@RequestBody VacinaDTO vacinaDTO) throws VacinaCadastroInvalido {
        Vacina novaVacina = vacinaService.saveVacina(vacinaDTO);
        return new ResponseEntity<Vacina>(novaVacina, HttpStatus.CREATED);
    }


}
