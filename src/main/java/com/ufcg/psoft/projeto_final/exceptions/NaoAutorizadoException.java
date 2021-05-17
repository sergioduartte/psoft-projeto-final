package com.ufcg.psoft.projeto_final.exceptions;

public class NaoAutorizadoException extends Exception{

    static final String SEM_AUTORIZACAO = "ERRO: sem autorizacao!";

    public NaoAutorizadoException() {
        super(SEM_AUTORIZACAO);
    }
}
