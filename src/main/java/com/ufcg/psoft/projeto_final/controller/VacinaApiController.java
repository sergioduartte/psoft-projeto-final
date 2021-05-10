package com.ufcg.psoft.projeto_final.controller;


import com.ufcg.psoft.projeto_final.DTOs.VacinaDTO;
import com.ufcg.psoft.projeto_final.entidades.Vacina;
import com.ufcg.psoft.projeto_final.services.VacinaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
public class VacinaApiController {
	@Autowired
	VacinaService vacinaService;

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping("")
    public ResponseEntity<Vacina> criarVacina(@RequestBody VacinaDTO vacinaDTO) {
        Vacina novaVacina = vacinaService.criaTipoVacina(vacinaDTO);
        return new ResponseEntity<Vacina>(novaVacina, HttpStatus.CREATED);
    }

}
