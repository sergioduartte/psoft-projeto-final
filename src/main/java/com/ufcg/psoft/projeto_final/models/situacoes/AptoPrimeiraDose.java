package com.ufcg.psoft.projeto_final.models.situacoes;

import com.ufcg.psoft.projeto_final.models.Cidadao;


public class AptoPrimeiraDose extends Situacao {

    @Override
    public void habilitaCidadao(Cidadao cidadao) {
    }

    @Override
    public void atualizaSituacao(Cidadao cidadao, Integer dosesNecessarias) {
        if (dosesNecessarias == 2) {
            EnumSituacoes situacao = EnumSituacoes.ESPERANDO_SEGUNDA_DOSE;
            cidadao.setSituacao(situacao);
        } else {
            EnumSituacoes situacao = EnumSituacoes.VACINACAO_FINALIZADA;
            cidadao.setSituacao(situacao);
        }
    }

    @Override
    public String toString() {
        return "Apto Primeira Dose!";
    }

}


