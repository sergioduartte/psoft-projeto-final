package com.ufcg.psoft.projeto_final.errors;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_ACCEPTABLE)
public class CidadaoCadastroInvalido extends Throwable {
    static final String CIDADO_INVALIDO = "Cidadao não pode ser cadastrado. Motivo: %s";
    public CidadaoCadastroInvalido(String atributoInvalido) {
        super(String.format(CIDADO_INVALIDO, atributoInvalido));
    }
}
