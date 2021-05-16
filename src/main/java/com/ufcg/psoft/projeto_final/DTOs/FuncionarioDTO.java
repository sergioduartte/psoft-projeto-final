package com.ufcg.psoft.projeto_final.DTOs;

public class FuncionarioDTO {
    private Long cpf;
    private String cargo;
    private String localTrabalho;

    public FuncionarioDTO(Long cpf, String cargo, String localTrabalho) {
        this.cpf = cpf;
        this.cargo = cargo;
        this.localTrabalho = localTrabalho;
    }

    public Long getCpf() {
        return cpf;
    }

    public String getCargo() {
        return cargo;
    }

    public String getLocalTrabalho() {
        return localTrabalho;
    }
}
