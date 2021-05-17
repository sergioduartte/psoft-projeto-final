package com.ufcg.psoft.projeto_final.DTOs;

import java.util.List;

import io.swagger.annotations.ApiModelProperty;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;

public class CidadaoDTO {

    @ApiModelProperty(example = "José da Silva")
    private String nomeCompleto;

    @ApiModelProperty(example = "Rua 7 de Setembro, 124, Centro, São Paulo - SP")
    private String endereco;

    @ApiModelProperty(example = "00000000000")
    private Long cpf;

    @ApiModelProperty(example = "294867205917493")
    private String cartaoSus;

    @ApiModelProperty(example = "jose123@gmail.com")
    private String email;

    @ApiModelProperty(example = "30/12/2000")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private String dataNascimento;

    @ApiModelProperty(example = "83998115533")
    private String telefone;

    @ApiModelProperty(example = "Estudante")
    private String profissao;

    @ApiModelProperty(example = "[\"diabetes\", \"câncer\"]")
    private List<String> comorbidades;

    @ApiModelProperty(example = "1234abcd")
    private String senha;

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public String getProfissao() {
            return profissao;
        }

        public List<String> getComorbidades() {
            return comorbidades;
        }

    public String getEndereco() {
        return endereco;
    }

    public Long getCpf() {
        return cpf;
    }

    public String getCartaoSus() {
        return cartaoSus;
    }

    public String getEmail() {
        return email;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getSenha() { return this.senha; }
}