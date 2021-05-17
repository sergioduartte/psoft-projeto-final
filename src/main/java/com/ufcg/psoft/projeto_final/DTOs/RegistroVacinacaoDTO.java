package com.ufcg.psoft.projeto_final.DTOs;

import java.sql.Date;

public class RegistroVacinacaoDTO {

    private final Long idCidadao;

    private final Long idLote;

    private final Date dataAplicacao;

    public RegistroVacinacaoDTO(Long cpfCidadao, Long idVacina, Date dataAplicacao) {
        this.idCidadao = cpfCidadao;
        this.idLote = idVacina;
        this.dataAplicacao = dataAplicacao;
    }

    public Long getIdCidadao() {
        return this.idCidadao;
    }

    public Long getIdLote() {
        return this.idLote;
    }

    public Date getDataAplicacao() {
        return this.dataAplicacao;
    }

}
