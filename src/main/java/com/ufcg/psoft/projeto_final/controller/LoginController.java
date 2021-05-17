package com.ufcg.psoft.projeto_final.controller;

import com.ufcg.psoft.projeto_final.services.LoginResponse;
import com.ufcg.psoft.projeto_final.web_security.JwtTokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ufcg.psoft.projeto_final.DTOs.LoginDTO;
import com.ufcg.psoft.projeto_final.erro.LoginInvalido;
import com.ufcg.psoft.projeto_final.erro.LoginTipoInvalido;
import com.ufcg.psoft.projeto_final.services.LoginService;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class LoginController {

	@Autowired
	private JwtTokenService JWTService;

	@PostMapping("/auth/login") //TODO CRIAR EXCEPTIONS E TRATAR
	public ResponseEntity<?> login(@RequestBody LoginDTO loginDTO) throws LoginInvalido, LoginTipoInvalido {
		LoginResponse jwt = JWTService.autentica(loginDTO);
		return new ResponseEntity<>(jwt, HttpStatus.OK);

	}

}