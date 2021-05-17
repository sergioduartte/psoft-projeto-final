package com.ufcg.psoft.projeto_final.models.situacoes;

import com.ufcg.psoft.projeto_final.models.Cidadao;


public class AptoSegundaDose extends Situacao {

    @Override
    public void habilitaCidadao(Cidadao cidadao) {
    }

    @Override
    public void atualizaSituacao(Cidadao cidadao, Integer dosesNecessarias) {
        EnumSituacoes situacao = EnumSituacoes.VACINACAO_FINALIZADA;
        cidadao.setSituacao(situacao);
    }

    @Override
    public String toString() {
        return "Apto Segunda Dose!";
    }

}
