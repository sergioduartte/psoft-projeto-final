package com.ufcg.psoft.projeto_final.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ufcg.psoft.projeto_final.DTOs.RegistroVacinacaoDTO;
import com.ufcg.psoft.projeto_final.entidades.RegistroVacinacao;
import com.ufcg.psoft.projeto_final.entidades.Vacina;
import com.ufcg.psoft.projeto_final.entidades.situacoes.Situacao;
import com.ufcg.psoft.projeto_final.erro.VacinaNaoEncontrada;

import com.ufcg.psoft.projeto_final.services.RegistroVacinacaoService;
import com.ufcg.psoft.projeto_final.services.VacinaService;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class RegistroVacinacaoApiController {
	
	@Autowired
	RegistroVacinacaoService registroVacinacaoService;
	
	@PostMapping("/registroPrimeiraDose")
	public ResponseEntity<?> registraAplicacaoPrimeiraDose(@RequestBody RegistroVacinacaoDTO registroVacinacaoDTO) throws VacinaNaoEncontrada{

		RegistroVacinacao registroVacinacao = registroVacinacaoService.salvar(registroVacinacaoDTO);

        return new ResponseEntity<RegistroVacinacao>(registroVacinacao, HttpStatus.CREATED);

	
	}
}
