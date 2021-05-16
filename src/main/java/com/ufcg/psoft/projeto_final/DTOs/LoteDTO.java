package com.ufcg.psoft.projeto_final.DTOs;

public class LoteDTO {


    private String fabricanteVacina;
    private String dataValidade;
    private Integer qtdDoses;
    private Long idTipoVacina;

    public LoteDTO(String dataValidade, Integer qtdDoses, String fabricanteVacina, Long idTipoVacina){
        super();
        this.dataValidade = dataValidade;
        this.qtdDoses = qtdDoses;
        this.fabricanteVacina = fabricanteVacina;
        this.idTipoVacina = idTipoVacina;
    }

    public String getFabricanteVacina(){ return fabricanteVacina;}

    public Integer getQtdDoses() {
        return qtdDoses;
    }

    public String getDataValidade(){
        return dataValidade;
    }

    public Long getIdTipoVacina() { return idTipoVacina; }

}
