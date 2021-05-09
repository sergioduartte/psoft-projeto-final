package com.ufcg.psoft.projeto_final.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ufcg.psoft.projeto_final.DTOs.LoginDTO;
import com.ufcg.psoft.projeto_final.erro_login.LoginInvalido;
import com.ufcg.psoft.projeto_final.erro_login.LoginTipoInvalido;
import com.ufcg.psoft.projeto_final.services.LoginService;

@RestController
@RequestMapping("/login")
@CrossOrigin
public class LoginController {

    @Autowired
    LoginService loginService;

    @PostMapping("")
	public ResponseEntity<?> login(@RequestBody LoginDTO loginDTO) throws LoginInvalido, LoginTipoInvalido {
    	String jwt = loginService.login(loginDTO);
	    return new ResponseEntity<>(jwt, HttpStatus.OK);
	}	
}
