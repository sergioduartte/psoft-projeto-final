package com.ufcg.psoft.projeto_final.entidades;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.sun.istack.NotNull;

@Entity
public class Vacina {
	
	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
	
    @NotNull
	private String fabricante;
    @NotNull
	private Integer dosesNecessarias;
    @NotNull
	private Integer intervaloDoses;
    
    public Vacina() {
	}
    
    public Vacina(String fabricante, Integer dosesNecessarias, Integer intervaloDoses) {
    	this.fabricante = fabricante;
    	this.dosesNecessarias = dosesNecessarias;
    	this.intervaloDoses = intervaloDoses;
	}

	public Long getId() {
		return id;
	}

	public String getFabricante() {
		return fabricante;
	}

	public Integer getDosesNecessarias() {
		return dosesNecessarias;
	}

	public Integer getIntervaloDoses() {
		return intervaloDoses;
	}
}
