package com.ufcg.psoft.projeto_final.erro;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class LoteNaoEncontrado extends Exception {

    static final String LOTE_NAO_ENCONTRADO = "O Lote com o ID %s não foi encontrado.";

    public LoteNaoEncontrado(Long idLote) {
        super(String.format(LOTE_NAO_ENCONTRADO, idLote));
    }
}