package com.ufcg.psoft.projeto_final.controller;

import com.ufcg.psoft.projeto_final.entidades.Cidadao;
import com.ufcg.psoft.projeto_final.services.CidadaoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Optional;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class CidadaoApiController {

    @Autowired
    CidadaoService cidadaoService;

    @PostMapping("/cidadao")
    public ResponseEntity<?> cadastrarCidadao(@RequestBody Cidadao cidadao, UriComponentsBuilder ucBuilder) {

        Optional<Cidadao> optionalCidadao = cidadaoService.getCidadao(cidadao.getCpf());
        if (optionalCidadao.isPresent()) {
            // return ErroCidadao.cidadaoJaCadastrado(cidadao.getCpf());
        }
        Cidadao novoCidadao = cidadaoService.adicionaCidadao(cidadao);

        return new ResponseEntity<Cidadao>(novoCidadao, HttpStatus.OK);

    }

}
