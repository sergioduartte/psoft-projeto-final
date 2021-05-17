package com.ufcg.psoft.projeto_final.controller;

import com.ufcg.psoft.projeto_final.DTOs.AgendaDTO;
import com.ufcg.psoft.projeto_final.DTOs.CidadaoDTO;
import com.ufcg.psoft.projeto_final.entidades.*;
import com.ufcg.psoft.projeto_final.entidades.situacoes.EnumSituacoes;
import com.ufcg.psoft.projeto_final.erro.AgendamentoCadastroInvalido;
import com.ufcg.psoft.projeto_final.erro.CidadaoCadastroInvalido;
import com.ufcg.psoft.projeto_final.erro.ErroCidadao;
import com.ufcg.psoft.projeto_final.erro.LoginTipoInvalido;
import com.ufcg.psoft.projeto_final.services.AgendaService;
import com.ufcg.psoft.projeto_final.services.AgendaServiceImpl;
import com.ufcg.psoft.projeto_final.services.CidadaoService;
import com.ufcg.psoft.projeto_final.DTOs.AtualizaCidadaoDTO;
import com.ufcg.psoft.projeto_final.DTOs.CidadaoDTO;
import io.swagger.annotations.ApiOperation;
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

    @ApiOperation(value = "Cadastra um Cidadao")
    @PostMapping("/cidadao")
    public ResponseEntity<Login> cidadao(@RequestBody CidadaoDTO cidadaoDTO) throws CidadaoCadastroInvalido, LoginTipoInvalido {
        Login loginCidadao = cidadaoService.saveCidadao(cidadaoDTO);
        return new ResponseEntity<Login>(loginCidadao, HttpStatus.OK);
    }

    @ApiOperation(value = "Altera o cadastro de um Cidadao a partir de seu CPF")
    @PostMapping("/cidadao/cadastro")
    public ResponseEntity<?> editaCadastro(@RequestParam Long cpf, @RequestBody AtualizaCidadaoDTO atualizaCidadaoDTO){
        Cidadao cidadao = cidadaoService.getCidadao(cpf);
        if(cidadao == null) {
            return ErroCidadao.cidadaoInexistente(cpf);
        }

        return new ResponseEntity<>(cidadaoService.atualizaCadastro(cpf, atualizaCidadaoDTO), HttpStatus.OK);
    }

    @ApiOperation(value = "Retorna a situacao de um Cidadao a partir de seu CPF")
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
