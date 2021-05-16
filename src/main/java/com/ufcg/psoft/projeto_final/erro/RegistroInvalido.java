package com.ufcg.psoft.projeto_final.erro;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_ACCEPTABLE)
public class RegistroInvalido extends Exception {
    static final String REGISTRO_INVALIDO = "Registro de vacinacao nao pode ser efetuado. Motivo: %s";
    public RegistroInvalido(String motivo) {
        super(String.format(REGISTRO_INVALIDO, motivo));
    }
}
