package com.example.projeto_final_psoft.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;
import com.example.projeto_final_psoft.entidades.*;
import com.example.projeto_final_psoft.service.*;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class CidadaoApiController {

    @Autowired
    CidadaoService cidadaoService;

    public ResponseEntity<?> cadastrarCidadao(@RequestBody Cidadao cidadao, UriComponentsBuilder ucBuilder) {

        Optional<Cidadao> optionalCidadao = cidadaoService.getCidadao(cidadao.getCpf());
        if (optionalCidadao.isPresent()) {
            // return ErroCidadao.cidadaoJaCadastrado(cidadao.getCpf());
        }
        Cidadao novoCidadao = cidadaoService.adicionaCidadao(cidadao);

        return new ResponseEntity<Cidadao>(novoCidadao, HttpStatus.OK);

    }

}
