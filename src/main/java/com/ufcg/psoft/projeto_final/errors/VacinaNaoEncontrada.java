package com.ufcg.psoft.projeto_final.errors;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class VacinaNaoEncontrada extends Exception {

    static final String VACINA_NAO_ENCONTRADA = "A vacina com o ID %s não foi encontrada.";

    public VacinaNaoEncontrada(Long idVacina) {
        super(String.format(VACINA_NAO_ENCONTRADA, idVacina));
    }
}