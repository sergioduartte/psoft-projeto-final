package com.ufcg.psoft.projeto_final.erro;

public class FuncionarioCadastroInvalido extends Throwable {
    static final String FUNCIONARIO_INVALIDO = "Funcionario nao pode ser cadastrado. Motivo: %s";
    public FuncionarioCadastroInvalido(String atributoInvalido) {
        super(String.format(FUNCIONARIO_INVALIDO, atributoInvalido));
    }
}
