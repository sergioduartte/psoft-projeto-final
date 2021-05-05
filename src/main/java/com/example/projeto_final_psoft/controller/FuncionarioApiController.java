package com.example.projeto_final_psoft.controller;

import com.example.projeto_final_psoft.DTOs.FuncionarioDTO;
import com.example.projeto_final_psoft.entidades.Cidadao;
import com.example.projeto_final_psoft.service.CidadaoService;
import com.example.projeto_final_psoft.service.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Optional;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class FuncionarioApiController {

    @Autowired
    FuncionarioService funcionarioService;

    public ResponseEntity<?> cadastrarFuncionario(@RequestBody FuncionarioDTO funcionario, UriComponentsBuilder ucBuilder) {

        return funcionarioService.adicionaFuncionario(funcionario);

    }
}
