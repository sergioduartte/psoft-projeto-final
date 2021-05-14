package com.ufcg.psoft.projeto_final.exceptions;

public class CadastroLoteException extends Exception {
    public CadastroLoteException(String atributoInadequado) {
        super(atributoInadequado);
    }
}
