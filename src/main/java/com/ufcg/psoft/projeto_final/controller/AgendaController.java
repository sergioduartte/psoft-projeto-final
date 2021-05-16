package com.ufcg.psoft.projeto_final.controller;

import com.ufcg.psoft.projeto_final.DTOs.AgendaDTO;
import com.ufcg.psoft.projeto_final.DTOs.CidadaoDTO;
import com.ufcg.psoft.projeto_final.entidades.Agenda;
import com.ufcg.psoft.projeto_final.entidades.Vacina;
import com.ufcg.psoft.projeto_final.erro.AgendamentoCadastroInvalido;
import com.ufcg.psoft.projeto_final.services.AgendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public class AgendaController {

    @Autowired
    AgendaService agendaService;

    @GetMapping("/horariosDisponiveis")
    public ResponseEntity<List<Agenda>> getHorariosDisponiveis() {
        List<Agenda> horarios = agendaService.getHorarios();
        return new ResponseEntity<List<Agenda>>(horarios, HttpStatus.OK);
    }


    @PostMapping("/agenda")
    public ResponseEntity<Agenda> agenda(@RequestBody AgendaDTO agendaDTO) throws AgendamentoCadastroInvalido { //TODO validacao throws VacinaCadastroInvalido {
        Agenda agendamento = agendaService.alocaHorario(agendaDTO);
        return new ResponseEntity<Agenda>(agendamento, HttpStatus.OK);
    }


}
