package com.ufcg.psoft.projeto_final.DTOs;


import java.util.Date;

public class AgendaDTO {

    private Long id;
    private Long idCidadao;
    private final Date horario;

    private Integer dosagem;

    public AgendaDTO(Date horario) {
        this.horario = horario;
    }

    public AgendaDTO(Long idCidadao, Date horario, Integer dosagem) {
        this.idCidadao = idCidadao;
        this.horario = horario;
    }

    public Date getHorario() {
        return horario;
    }

    public Long getIdCidadao() {
        return idCidadao;
    }

    public Integer getDosagem() {
        return dosagem;
    }

    public boolean possuiAlocacao() {
        return idCidadao == null;
    }


}
