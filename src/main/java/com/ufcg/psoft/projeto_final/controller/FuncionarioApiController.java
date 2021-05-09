package com.ufcg.psoft.projeto_final.controller;

import com.ufcg.psoft.projeto_final.DTOs.FuncionarioDTO;
import com.ufcg.psoft.projeto_final.services.FuncionarioService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class FuncionarioApiController {

    @Autowired
    FuncionarioService funcionarioService;

    @PostMapping("/funcionario")
    public ResponseEntity<?> cadastrarFuncionario(@RequestBody FuncionarioDTO funcionario, UriComponentsBuilder ucBuilder) {

        return funcionarioService.adicionaFuncionario(funcionario);

    }
}
