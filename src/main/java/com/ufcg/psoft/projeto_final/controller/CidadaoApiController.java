package com.ufcg.psoft.projeto_final.controller;

import com.ufcg.psoft.projeto_final.DTOs.InsereCidadaoDTO;
import com.ufcg.psoft.projeto_final.entidades.*;
import com.ufcg.psoft.projeto_final.entidades.situacoes.EnumSituacoes;
import com.ufcg.psoft.projeto_final.erro.LoginTipoInvalido;
import com.ufcg.psoft.projeto_final.services.CidadaoService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.text.ParseException;
import java.util.Optional;


@RestController
@RequestMapping("/cidadao")
@CrossOrigin
public class CidadaoApiController {

    @Autowired
    CidadaoService cidadaoService;

    @PostMapping("/")
    public ResponseEntity<LoginCidadao> save(@RequestBody InsereCidadaoDTO insereCidadaoDTO) throws ParseException, LoginTipoInvalido {
        LoginCidadao loginCidadao = cidadaoService.save(insereCidadaoDTO);

        return new ResponseEntity<>(loginCidadao, HttpStatus.OK);
    }
    
    @GetMapping("/cidadao/consulta-situacao")
    public ResponseEntity<?> getSituacao(@RequestParam String cpf){
    	Optional<Cidadao> optionalCidadao = cidadaoService.getCidadao(cpf);
    	if(!optionalCidadao.isPresent()) {
    		
    	}
    	Cidadao cidadao = optionalCidadao.get();
    	EnumSituacoes situacao = cidadao.getSituacao();
    	return new ResponseEntity<>(situacao, HttpStatus.OK);
    }

}
