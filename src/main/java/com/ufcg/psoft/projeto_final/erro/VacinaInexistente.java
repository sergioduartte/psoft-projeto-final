package com.ufcg.psoft.projeto_final.erro;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_ACCEPTABLE)
public class VacinaInexistente extends Exception {
	
    static final String VACINA_INEXISTENTE = "O id %s de vacina não está cadastrado.";

    public VacinaInexistente(Long vacinaId) {
        super(String.format(VACINA_INEXISTENTE, vacinaId));
    }
}