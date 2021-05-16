package com.ufcg.psoft.projeto_final.DTOs;

import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Column;
import javax.validation.constraints.Size;
import java.util.List;

public class AtualizaCidadaoDTO {

    @ApiModelProperty(example = "José da Silva")
    private String nomeCompleto;

    @ApiModelProperty(example = "Rua 7 de Setembro, 124, Centro, São Paulo - SP")
    private String endereco;

    @ApiModelProperty(example = "jose123@gmail.com")
    private String email;

    @ApiModelProperty(example = "83998115533")
    @Column(length = 11)
    @Size(min = 11, max = 11)
    private String telefone;

    @ApiModelProperty(example = "Estudante")
    private String profissao;

    @ApiModelProperty(example = "[\"diabetes\", \"câncer\"]")
    private List<String> comorbidades;


    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public String getEndereco() {
        return endereco;
    }


    public String getEmail() {
        return email;
    }


    public String getTelefone() {
        return telefone;
    }

    public String getProfissao() {
        return profissao;
    }

    public List<String> getComorbidades() {
        return comorbidades;
    }
}