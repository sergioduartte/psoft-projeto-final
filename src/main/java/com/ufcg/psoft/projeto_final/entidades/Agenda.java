package com.ufcg.psoft.projeto_final.entidades;

import com.sun.istack.NotNull;
import com.ufcg.psoft.projeto_final.exceptions.CadastroVacinaException;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Agenda {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String idCidadao;

    @NotNull
    private Date data;

    public Agenda() {} // TODO throws CadastroAgendaException

    public Agenda(Date data) {
        this.data = data;
    }

    public Date getHorario(){
        return data;
    }

    public boolean possuiAlocacao() {
        return idCidadao == null;
    }
}

