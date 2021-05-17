package com.ufcg.psoft.projeto_final.controllers;

import com.ufcg.psoft.projeto_final.DTOs.AgendaDTO;
import com.ufcg.psoft.projeto_final.DTOs.CidadaoDTO;
import com.ufcg.psoft.projeto_final.models.*;
import com.ufcg.psoft.projeto_final.models.situacoes.EnumSituacoes;
import com.ufcg.psoft.projeto_final.errors.AgendamentoCadastroInvalido;
import com.ufcg.psoft.projeto_final.errors.CidadaoCadastroInvalido;
import com.ufcg.psoft.projeto_final.errors.LoginTipoInvalido;
import com.ufcg.psoft.projeto_final.exceptions.CidadaoNaoEncontradoException;
import com.ufcg.psoft.projeto_final.services.agenda.AgendaService;
import com.ufcg.psoft.projeto_final.services.cidadao.CidadaoService;
import com.ufcg.psoft.projeto_final.DTOs.AtualizaCidadaoDTO;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api")
@CrossOrigin
public class CidadaoController {

    @Autowired
    private CidadaoService cidadaoService;
    private AgendaService agendaService;

    @ApiOperation(value = "Cadastra um Cidadao")
    @PostMapping("/cidadao")
    public ResponseEntity<Cidadao> cidadao(@RequestBody CidadaoDTO cidadaoDTO) throws CidadaoCadastroInvalido, LoginTipoInvalido {
        Cidadao cidadao = cidadaoService.saveCidadao(cidadaoDTO);
        return new ResponseEntity<Cidadao>(cidadao, HttpStatus.CREATED);
    }

    @ApiOperation(value = "Altera o cadastro de um Cidadao a partir de seu CPF")
    @PostMapping("/cidadao/cadastro")
    public ResponseEntity<?> editaCadastro(@RequestParam Long cpf, @RequestBody AtualizaCidadaoDTO atualizaCidadaoDTO) throws CidadaoNaoEncontradoException {
        Cidadao cidadao = cidadaoService.getCidadao(cpf);
        if(cidadao == null) {
            //return ErroCidadao.cidadaoInexistente(cpf);
        }

        return new ResponseEntity<>(cidadaoService.atualizaCadastro(cpf, atualizaCidadaoDTO), HttpStatus.OK);
    }

    @ApiOperation(value = "Retorna a situacao de um Cidadao a partir de seu CPF")
    @GetMapping("/cidadao/consulta_situacao")
    public ResponseEntity<?> getSituacao(@RequestParam Long cpf) throws CidadaoNaoEncontradoException {
    	Cidadao cidadao = cidadaoService.getCidadao(cpf);
    	if(cidadao != null) {
    		//return ErroCidadao.cidadaoInexistente(cpf);
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
