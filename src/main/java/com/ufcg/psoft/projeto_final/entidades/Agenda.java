package com.ufcg.psoft.projeto_final.entidades;

import com.sun.istack.NotNull;
import com.ufcg.psoft.projeto_final.exceptions.CadastroAgendamentoException;

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

    private Long idCidadao;

    @NotNull
    private Date data;
    private Integer dosagem;

    public Agenda() {} // TODO throws CadastroAgendaException

    public Agenda(Date data) {
        this.data = data;
    }

    public Agenda(Long idCidadao, Date data, Integer dosagem) throws CadastroAgendamentoException{
        validaAgendamento(data);
        this.idCidadao = idCidadao;
        this.data = data;
        this.dosagem = dosagem;
    }

    private void validaAgendamento(Date data) throws CadastroAgendamentoException {

        if (data != null) { //TODO CHECAR A DATA EH VALIDA > QUE O DIA CORRENTE
            throw new CadastroAgendamentoException("Data da vacinacao tem de ser posterior ao dia do agendamento.");
        }
    }

    public Date getHorario(){
        return data;
    }

    public Long getIdCidadao(){ return idCidadao; }

    public Integer getDosagem() {
        return dosagem;
    }


    public boolean possuiAlocacao() {
        return idCidadao == null;
    }
}

