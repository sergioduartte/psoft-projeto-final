package com.ufcg.psoft.projeto_final.models;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class RegistroVacinacao {
	
	@Id
    Long Id;

    private Long idLote;

    private Date dataAplicacao;
    
    private Long cpfCidadao;


    RegistroVacinacao(){}

    public RegistroVacinacao(Long cpfCidadao, Long idLote, Date dataAplicacao){
        this.cpfCidadao = cpfCidadao;
        this.idLote = idLote;
        this.dataAplicacao = dataAplicacao;
    }

    public Long getCpfCidadao(){
        return this.cpfCidadao;
    }

    public Long getIdLote(){
        return this.idLote;
    }

    public Date getDataAplicacao(){
        return this.dataAplicacao;
    }

}

