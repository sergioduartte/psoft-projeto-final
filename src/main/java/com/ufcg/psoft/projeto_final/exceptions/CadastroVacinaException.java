package com.ufcg.psoft.projeto_final.exceptions;

public class CadastroVacinaException extends Exception {
    public CadastroVacinaException(String atributoInadequado) {
        super(atributoInadequado);
    }
}
