package com.ufcg.psoft.projeto_final.exceptions;

public class CidadaoNaoEncontradoException extends Exception {
    public CidadaoNaoEncontradoException(String atributoInadequado) {
        super(atributoInadequado);
    }
}
