package com.ufcg.psoft.projeto_final.erro;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_ACCEPTABLE)
public class VacinaCadastroInvalido extends Exception{
    static final String VACINA_INVALIDA = "Vacina não pode ser cadastrada. Motivo: %s";
    public VacinaCadastroInvalido(String atributoInvalido) {
        super(String.format(VACINA_INVALIDA, atributoInvalido));
    }
}
