package com.ufcg.psoft.projeto_final.DTOs;

import java.sql.Date;

public class RegistroVacinacaoDTO {
	
	private String cpfCidadao;

    private Long idVacina;

    private Date dataAplicacao;

    public RegistroVacinacaoDTO(String cpfCidadao, Long idVacina, Date dataAplicacao){
        this.cpfCidadao = cpfCidadao;
        this.idVacina = idVacina;
        this.dataAplicacao = dataAplicacao;
    }

    public String getCpfCidadao() {
        return this.cpfCidadao;
    }

    public void setCpfCidadao(String cpfCidadao) {
        this.cpfCidadao = cpfCidadao;
    }

    public Long getIdVacina() {
        return this.idVacina;
    }

    public void setIdVacina(Long idVacina) {
        this.idVacina = idVacina;
    }

    public Date getDataAplicacao() {
        return this.dataAplicacao;
    }

    public void setDataAplicacao(Date dataAplicacao) {
        this.dataAplicacao = dataAplicacao;
    }

}
