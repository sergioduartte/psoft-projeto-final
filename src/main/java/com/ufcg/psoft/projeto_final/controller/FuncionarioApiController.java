package com.ufcg.psoft.projeto_final.controller;

import com.ufcg.psoft.projeto_final.DTOs.FuncionarioDTO;
import com.ufcg.psoft.projeto_final.entidades.Cidadao;
import com.ufcg.psoft.projeto_final.entidades.LoginCidadao;
import com.ufcg.psoft.projeto_final.entidades.LoginFuncionario;
import com.ufcg.psoft.projeto_final.entidades.situacoes.EnumSituacoes;
import com.ufcg.psoft.projeto_final.erro.ErroCidadao;
import com.ufcg.psoft.projeto_final.services.FuncionarioService;
import com.ufcg.psoft.projeto_final.services.CidadaoService;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class FuncionarioApiController {

    @Autowired
    FuncionarioService funcionarioService;
    CidadaoService cidadaoService;

    @PostMapping("/funcionario")
    public ResponseEntity<?> cadastrarFuncionario(@RequestBody FuncionarioDTO funcionario) {

        return funcionarioService.save(funcionario);
    }
    
    @PreAuthorize("hasRole('ROLE_FUNCIONARIO')")
    @PostMapping()
    public ResponseEntity<?> tornaCidadaoApto(@RequestParam String cpf){
    	Optional<Cidadao> optionalCidadao = cidadaoService.getCidadao(cpf);
    	if(!optionalCidadao.isPresent()) {
    		return ErroCidadao.cidadaoInexistente(cpf);
    	}
    	
    	Cidadao cidadao = optionalCidadao.get();
    	EnumSituacoes situacao = cidadao.getSituacao();
    	//depois, adicionar criterios de prioridade, por ex numero de doses, comorbidade, idade....
    	if(situacao.equals(EnumSituacoes.NAO_APTO)) {
    		EnumSituacoes novaSituacao = EnumSituacoes.APTO_PRIMEIRA_DOSE;
    		cidadao.setSituacao(novaSituacao);
    		return new ResponseEntity<>(novaSituacao, HttpStatus.OK);
    	}else if(situacao.equals(EnumSituacoes.TOMOU_PRIMEIRA_DOSE)){
    		EnumSituacoes novaSituacao = EnumSituacoes.APTO_SEGUNDA_DOSE;
    		cidadao.setSituacao(novaSituacao);
    		return new ResponseEntity<>(novaSituacao, HttpStatus.OK);
    	}
    	
    	return new ResponseEntity<>("infelizmente, não foi possível tornar o cidadão apto", HttpStatus.OK);
    	
    }
}
