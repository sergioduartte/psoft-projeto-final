package com.ufcg.psoft.projeto_final.controller;

import com.ufcg.psoft.projeto_final.entidades.Agenda;
import com.ufcg.psoft.projeto_final.entidades.Vacina;
import com.ufcg.psoft.projeto_final.services.AgendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

public class AgendaController {

    @Autowired
    AgendaService agendaService;

    @GetMapping("/horariosDisponiveis")
    public ResponseEntity<List<Agenda>> getHorariosDisponiveis() {
        List<Agenda> horarios = agendaService.getHorarios();
        return new ResponseEntity<List<Agenda>>(horarios, HttpStatus.OK);
    }
//
//    @PreAuthorize("hasRole('ROLE_ADMIN') OR hasRole('ROLE_FUNCIONARIO')")
//    @GetMapping("/vacina/{id}")
//    public ResponseEntity<Vacina> getVacinaById(@RequestParam Long id) throws VacinaNaoEncontrada {
//        Optional<Vacina> optionalVacina = vacinaService.getVacinaById(id);
//        Vacina vacina = optionalVacina.get();
//        return new ResponseEntity<Vacina>(vacina, HttpStatus.OK);
//    }
//
//    @PreAuthorize("hasRole('ROLE_ADMIN')")
//    @PostMapping("/vacina")
//    public ResponseEntity<Vacina> vacina(@RequestBody VacinaDTO vacinaDTO) throws VacinaCadastroInvalido {
//        Vacina novaVacina = vacinaService.saveVacina(vacinaDTO);
//        return new ResponseEntity<Vacina>(novaVacina, HttpStatus.CREATED);
//    }


}
