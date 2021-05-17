package com.ufcg.psoft.projeto_final.exceptions;

public class CadastroAgendamentoException extends Exception {

    public CadastroAgendamentoException(String atributoInadequado) {
        super(atributoInadequado);
    }
}
