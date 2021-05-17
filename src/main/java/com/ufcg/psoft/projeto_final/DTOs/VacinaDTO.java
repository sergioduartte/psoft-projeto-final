package com.ufcg.psoft.projeto_final.DTOs;

public class VacinaDTO {

    private final String fabricante;

    private final Integer dosesNecessarias;

    private final Integer intervaloDoses;

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
