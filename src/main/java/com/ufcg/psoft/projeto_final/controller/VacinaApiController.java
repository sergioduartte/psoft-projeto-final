package com.ufcg.psoft.projeto_final.controller;


import com.ufcg.psoft.projeto_final.DTOs.VacinaDTO;
import com.ufcg.psoft.projeto_final.entidades.Vacina;
import com.ufcg.psoft.projeto_final.erro.VacinaCadastroInvalido;
import com.ufcg.psoft.projeto_final.erro.VacinaNaoEncontrada;
import com.ufcg.psoft.projeto_final.services.VacinaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class VacinaApiController {
	@Autowired
	VacinaService vacinaService;

    @PreAuthorize("hasRole('ROLE_ADMIN') OR hasRole('ROLE_FUNCIONARIO')")
    @GetMapping("/vacina")
    public ResponseEntity<List<Vacina>> getVacinas() {
        List<Vacina> vacinas = vacinaService.getVacina();
        return new ResponseEntity<List<Vacina>>(vacinas, HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN') OR hasRole('ROLE_FUNCIONARIO')")
    @GetMapping("/vacina/{id}")
    public ResponseEntity<Vacina> getVacinaById(@RequestParam Long id) throws VacinaNaoEncontrada {
        Optional<Vacina> optionalVacina = vacinaService.getVacinaById(id);
        Vacina vacina = optionalVacina.get();
        return new ResponseEntity<Vacina>(vacina, HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping("/vacina")
    public ResponseEntity<Vacina> vacina(@RequestBody VacinaDTO vacinaDTO) throws VacinaCadastroInvalido {
        Vacina novaVacina = vacinaService.saveVacina(vacinaDTO);
        return new ResponseEntity<Vacina>(novaVacina, HttpStatus.CREATED);
    }


}
