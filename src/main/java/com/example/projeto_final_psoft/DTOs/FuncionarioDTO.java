package com.example.projeto_final_psoft.DTOs;

public class FuncionarioDTO {
    private String cpf;
    private String cargo;
    private String localTrabalho;

    public FuncionarioDTO(String cpf, String cargo, String localTrabalho) {
        this.cpf = cpf;
        this.cargo = cargo;
        this.localTrabalho = localTrabalho;
    }

    public String getCpf() {
        return cpf;
    }

    public String getCargo() {
        return cargo;
    }

    public String getLocalTrabalho() {
        return localTrabalho;
    }
}
