package com.ufcg.psoft.projeto_final.erro;

public class FuncionarioNaoEncontrado extends Exception {

    static final String FUNCIONARIO_NAO_ENCONTRADO = "O Funcionario com o CPF %d não foi encontrado.";

    public FuncionarioNaoEncontrado(Long cpfFuncionario) {
        super(String.format(FUNCIONARIO_NAO_ENCONTRADO, cpfFuncionario));
    }
}
