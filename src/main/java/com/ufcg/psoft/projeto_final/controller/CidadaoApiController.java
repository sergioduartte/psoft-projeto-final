package com.ufcg.psoft.projeto_final.controller;

import com.ufcg.psoft.projeto_final.DTOs.AgendaDTO;
import com.ufcg.psoft.projeto_final.DTOs.CidadaoDTO;
import com.ufcg.psoft.projeto_final.entidades.*;
import com.ufcg.psoft.projeto_final.entidades.situacoes.EnumSituacoes;
import com.ufcg.psoft.projeto_final.erro.AgendamentoCadastroInvalido;
import com.ufcg.psoft.projeto_final.erro.ErroCidadao;
import com.ufcg.psoft.projeto_final.erro.LoginTipoInvalido;
import com.ufcg.psoft.projeto_final.services.AgendaService;
import com.ufcg.psoft.projeto_final.services.AgendaServiceImpl;
import com.ufcg.psoft.projeto_final.services.CidadaoService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.text.ParseException;
import java.util.Optional;


@RestController
@RequestMapping("/api")
@CrossOrigin
public class CidadaoApiController {

    @Autowired
    private CidadaoService cidadaoService;
    private AgendaService agendaService;

    @PostMapping("/cidadao")
    public ResponseEntity<LoginCidadao> save(@RequestBody CidadaoDTO cidadaoDTO) throws ParseException, LoginTipoInvalido {
        LoginCidadao loginCidadao = cidadaoService.save(cidadaoDTO);

        return new ResponseEntity<>(loginCidadao, HttpStatus.OK);
    }
    
    @GetMapping("/cidadao/consulta_situacao")
    public ResponseEntity<?> getSituacao(@RequestParam Long cpf){
    	Cidadao cidadao = cidadaoService.getCidadao(cpf);
    	if(cidadao != null) {
    		return ErroCidadao.cidadaoInexistente(cpf);
    	}
    	EnumSituacoes situacao = cidadao.getSituacao();
    	return new ResponseEntity<>(situacao, HttpStatus.OK);
    }

    @PostMapping("/agenda")
    public ResponseEntity<Agenda> agenda(@RequestBody AgendaDTO agendaDTO) throws AgendamentoCadastroInvalido {
        Agenda agendamento = agendaService.alocaHorario(agendaDTO);
        return new ResponseEntity<Agenda>(agendamento, HttpStatus.OK);
    }

}
