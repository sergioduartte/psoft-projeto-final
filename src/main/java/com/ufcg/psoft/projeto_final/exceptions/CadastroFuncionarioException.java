package com.ufcg.psoft.projeto_final.exceptions;

public class CadastroFuncionarioException extends Exception{
    public CadastroFuncionarioException(String atributoInadequado) {
        super(atributoInadequado);
    }
}
