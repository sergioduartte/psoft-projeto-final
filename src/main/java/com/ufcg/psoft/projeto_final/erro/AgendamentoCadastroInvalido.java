package com.ufcg.psoft.projeto_final.erro;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_ACCEPTABLE)
public class AgendamentoCadastroInvalido extends Exception {

    static final String AGENDAMENTO_NAO_PERMITIDO = "O agendamento nao pode ser realizado. Motivo: %s";

    public AgendamentoCadastroInvalido(String motivo) {
        super(String.format(AGENDAMENTO_NAO_PERMITIDO, motivo));
    }

}
