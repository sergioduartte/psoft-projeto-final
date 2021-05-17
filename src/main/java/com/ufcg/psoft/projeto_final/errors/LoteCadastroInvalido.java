package com.ufcg.psoft.projeto_final.errors;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_ACCEPTABLE)
public class LoteCadastroInvalido extends Exception{
    static final String LOTE_INVALIDO = "Lote não pode ser cadastrado. Motivo: %s";
    public LoteCadastroInvalido(String atributoInvalido) {
        super(String.format(LOTE_INVALIDO, atributoInvalido));
    }
}
