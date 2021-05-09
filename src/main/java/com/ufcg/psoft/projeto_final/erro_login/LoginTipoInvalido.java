package com.ufcg.psoft.projeto_final.erro_login;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class LoginTipoInvalido extends Exception {

	static final String STATUS_INVALIDO = "ERRO: Tipo %s de Login nao existente!";

    public LoginTipoInvalido(String loginTipo) {
        super(String.format(STATUS_INVALIDO, loginTipo));
    }
}
