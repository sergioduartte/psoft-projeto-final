package com.ufcg.psoft.projeto_final.DTOs;

public class LoteDTO {


    private String tipoVacina;
    private String dataValidade;
    private Integer qtdDoses;
    private Long idTipoVacina;

    public LoteDTO(String dataValidade, Integer qtdDoses, String tipoVacina, Long idTipoVacina){
        super();
        this.dataValidade = dataValidade;
        this.qtdDoses = qtdDoses;
        this.tipoVacina = tipoVacina;
        this.idTipoVacina = idTipoVacina;
    }

    public String getTipoVacina(){ return tipoVacina;}

    public Integer getQtdDoses() {
        return qtdDoses;
    }

    public String getDataValidade(){
        return dataValidade;
    }

    public Long getIdTipoVacina() { return idTipoVacina; }

}
