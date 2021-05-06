package com.example.projeto_final_psoft.entidades;

public class Funcionario extends Cidadao {

    private String cargo;
    private String localTrabalho;

    public Funcionario(String nome, String endereco, String cpf, String numeroSUS, String email, String dataNascimento,
                       String telefone, String profissao, String comorbidades, String cargo, String localTrabalho) {
        super(nome, endereco, cpf, numeroSUS, email, dataNascimento, telefone, profissao, comorbidades);
        this.cargo = cargo;
        this.localTrabalho = localTrabalho;
    }


}
