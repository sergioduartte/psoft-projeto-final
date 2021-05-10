package com.ufcg.psoft.projeto_final.DTOs;

public class VacinaDTO {
	
	private String fabricante;
	
	private Integer dosesNecessarias;

	private Integer intervaloDoses;

	public VacinaDTO(String fabricante, Integer dosesNecessarias, Integer intervaloDoses) {
		super();
		this.fabricante = fabricante;
		this.dosesNecessarias = dosesNecessarias;
		this.intervaloDoses = intervaloDoses;
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
