package com.ufcg.psoft.projeto_final.DTOs;

public class LoteDTO {

    private Long idVacina;
    private String data_validade;
    private Integer qtd_doses;


    public LoteDTO(String data_validade, Integer qtd_doses, Long idVacina){
        super();
        this.data_validade =  data_validade;
        this.qtd_doses = qtd_doses;
        this.idVacina = idVacina;
    }
     public Long getIdVacina(){
        return idVacina;
     }

    public Integer getQtdDoses() {
        return qtd_doses;
    }

    public String getDataValidade(){
        return data_validade;
    }
}
