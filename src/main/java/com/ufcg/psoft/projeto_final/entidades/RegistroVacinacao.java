package com.ufcg.psoft.projeto_final.entidades;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;

@Entity
public class RegistroVacinacao {
	
	@Id
    Long Id;

    private Long idVacina;

    private Date dataAplicacao;
    
    private String cpfCidadao;


    RegistroVacinacao(){}

    public RegistroVacinacao(String cpfCidadao, Long idVacina, Date dataAplicacao){
        this.cpfCidadao = cpfCidadao;
        this.idVacina = idVacina;
        this.dataAplicacao = dataAplicacao;
    }

    public String getCofCidadao(){
        return this.cpfCidadao;
    }
    public Long getIdVacina(){
        return this.idVacina;
    }

    public Date getDataAplicacao(){
        return this.dataAplicacao;
    }

}

