package com.ufcg.psoft.projeto_final.controllers;

import com.ufcg.psoft.projeto_final.DTOs.AgendaDTO;
import com.ufcg.psoft.projeto_final.DTOs.AtualizaCidadaoDTO;
import com.ufcg.psoft.projeto_final.DTOs.CidadaoDTO;
import com.ufcg.psoft.projeto_final.errors.AgendamentoCadastroInvalido;
import com.ufcg.psoft.projeto_final.errors.CidadaoCadastroInvalido;
import com.ufcg.psoft.projeto_final.errors.LoginTipoInvalido;
import com.ufcg.psoft.projeto_final.exceptions.CadastroCidadaoException;
import com.ufcg.psoft.projeto_final.exceptions.CidadaoNaoEncontradoException;
import com.ufcg.psoft.projeto_final.exceptions.NaoAutorizadoException;
import com.ufcg.psoft.projeto_final.models.Agenda;
import com.ufcg.psoft.projeto_final.models.Cidadao;
import com.ufcg.psoft.projeto_final.models.situacoes.EnumSituacoes;
import com.ufcg.psoft.projeto_final.services.agenda.AgendaService;
import com.ufcg.psoft.projeto_final.services.cidadao.CidadaoService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
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

    @ApiOperation(value = "Cadastra um Cidadao no sistema")
    @PostMapping("/cidadao")
    public ResponseEntity<Cidadao> cidadao(@RequestBody CidadaoDTO cidadaoDTO) throws CidadaoCadastroInvalido, LoginTipoInvalido {
        Cidadao cidadao = cidadaoService.saveCidadao(cidadaoDTO);
        return new ResponseEntity<Cidadao>(cidadao, HttpStatus.CREATED);
    }

    @ApiOperation(value = "Altera o cadastro de um Cidadao a partir de seu CPF")
    @PostMapping("/cidadao/cadastro")
    public ResponseEntity<Cidadao> editaCadastro(@RequestBody AtualizaCidadaoDTO atualizaCidadaoDTO, @RequestHeader HttpHeaders headers) throws CidadaoNaoEncontradoException, CadastroCidadaoException, CidadaoCadastroInvalido, NaoAutorizadoException {
        Cidadao cidadao = cidadaoService.atualizaCadastro(atualizaCidadaoDTO, headers);
        return new ResponseEntity<Cidadao>(cidadao, HttpStatus.OK);
    }

    @ApiOperation(value = "Retorna a situa????o de um Cidadao a partir de seu CPF")
    @GetMapping("/cidadao/situacao")
    public ResponseEntity<EnumSituacoes> getSituacao(@RequestBody Long cpf, @RequestHeader HttpHeaders headers) throws CidadaoNaoEncontradoException, CidadaoCadastroInvalido, NaoAutorizadoException {
        EnumSituacoes situacao = cidadaoService.getSituacao(cpf, headers);
        return new ResponseEntity<>(situacao, HttpStatus.OK);
    }

    @ApiOperation(value = "Agenda a vacina????o de um cidadao de acordo com os parametros")
    @PostMapping("/agenda")
    public ResponseEntity<Agenda> agenda(@RequestBody AgendaDTO agendaDTO, @RequestHeader HttpHeaders headers) throws AgendamentoCadastroInvalido, NaoAutorizadoException, CidadaoCadastroInvalido, CidadaoNaoEncontradoException {
        Agenda agendamento = agendaService.alocaHorario(agendaDTO, headers);
        return new ResponseEntity<Agenda>(agendamento, HttpStatus.OK);
    }

}
