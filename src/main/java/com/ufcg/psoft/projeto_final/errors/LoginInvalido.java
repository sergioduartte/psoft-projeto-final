package com.ufcg.psoft.projeto_final.errors;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.FORBIDDEN)
public class LoginInvalido extends Exception {

    static final String LOGIN_INVALIDO = "ERRO: Login Invalido!";

    public LoginInvalido() {
        super(LOGIN_INVALIDO);
    }

}
