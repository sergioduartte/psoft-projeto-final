package com.ufcg.psoft.projeto_final.controller;

import com.ufcg.psoft.projeto_final.DTOs.FuncionarioDTO;
import com.ufcg.psoft.projeto_final.entidades.Cidadao;
import com.ufcg.psoft.projeto_final.entidades.LoginCidadao;
import com.ufcg.psoft.projeto_final.entidades.LoginFuncionario;
import com.ufcg.psoft.projeto_final.entidades.Vacina;
import com.ufcg.psoft.projeto_final.entidades.situacoes.EnumSituacoes;
import com.ufcg.psoft.projeto_final.erro.ErroCidadao;
import com.ufcg.psoft.projeto_final.services.FuncionarioService;
import com.ufcg.psoft.projeto_final.services.CidadaoService;

import java.util.List;
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
    @PostMapping("/funcionario/habilita_por_idade/{idade}")
    public ResponseEntity<List<Cidadao>> tornaCidadaoAptoPorIdade(@RequestParam Integer idade){
    	List<Cidadao> habilitados = funcionarioService.habilitaPorIdade(idade);

		return new ResponseEntity<List<Cidadao>>(habilitados, HttpStatus.OK);
    	
    }

    @PostMapping("/funcionario/habilita_por_comorbidade/{comorbidade}")
    public ResponseEntity<List<Cidadao> > tornaCidadaoAptoPorComorbidade(@RequestParam String comorbidade){
        List<Cidadao> habilitados = funcionarioService.habilitaPorComorbidade(comorbidade);

        return new ResponseEntity<List<Cidadao>>(habilitados, HttpStatus.OK);

    }

    @PostMapping("/funcionario/habilita_por_profissao/{profissao}")
    public ResponseEntity<List<Cidadao> > tornaCidadaoAptoPorProfissao(@RequestParam String profissao){
        List<Cidadao> habilitados = funcionarioService.habilitaPorComorbidade(profissao);

        return new ResponseEntity<List<Cidadao>>(habilitados, HttpStatus.OK);

    }
}
