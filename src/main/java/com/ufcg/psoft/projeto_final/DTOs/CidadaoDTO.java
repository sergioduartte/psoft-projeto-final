package com.ufcg.psoft.projeto_final.DTOs;

import java.util.List;

import io.swagger.annotations.ApiModelProperty;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.validation.constraints.Size;

public class CidadaoDTO {

    @ApiModelProperty(example = "José da Silva")
    private String nomeCompleto;

    @ApiModelProperty(example = "Rua 7 de Setembro, 124, Centro, São Paulo - SP")
    private String endereco;

    @ApiModelProperty(example = "00000000000")
    @Column(length = 11)
    @Size(min = 11, max = 11)
    private Long cpf;

    @ApiModelProperty(example = "294867205917493")
    @Column(length = 15)
    @Size(min = 15, max = 15)
    private String cartaoSus;

    @ApiModelProperty(example = "jose123@gmail.com")
    private String email;

    @ApiModelProperty(example = "30/12/2000")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private String dataNascimento;

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
}