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
    String cpfCidadao;
    
    @OneToOne( cascade = CascadeType.ALL)   
    @MapsId
    private Cidadao cidadao;

    @OneToOne( cascade = CascadeType.ALL)  
    private Vacina vacina;

    private Date dataAplicacao;

    private int dose;

    RegistroVacinacao(){}

    public RegistroVacinacao(Cidadao cidadao, Vacina vacina, Date dataAplicacao){
        this.cidadao = cidadao;
        this.vacina = vacina;
        this.dataAplicacao = dataAplicacao;
        this.dose = 1;
    }

    public Cidadao getCidadao(){
        return this.cidadao;
    }
    public Vacina getVacina(){
        return this.vacina;
    }
    
    public int getDose(){
        return this.dose;
    }

    public void tomouSegundaDose(){
        this.dose = 2;
    }

    public Date getDataAplicacao(){
        return this.dataAplicacao;
    }

}

