package com.example.projeto_final_psoft.entidades;

import javax.persistence.Entity;

@Entity
public class Funcionario extends Cidadao {

    private String cargo;
    private String localTrabalho;

    //TODO Removi o 'String comorbidades' do construtor ~sergio
    public Funcionario(String nome, String endereco, String cpf, String numeroSUS, String email, String dataNascimento,
                       String telefone, String profissao, String cargo, String localTrabalho) {
        //TODO removi o ', comorbidades' dos params ~sergio
        super(nome, endereco, cpf, numeroSUS, email, dataNascimento, telefone, profissao);
        this.cargo = cargo;
        this.localTrabalho = localTrabalho;
    }


    public Funcionario() {

    }
}
