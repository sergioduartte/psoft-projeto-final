package com.ufcg.psoft.projeto_final.models.situacoes;

import com.ufcg.psoft.projeto_final.models.Cidadao;

public class NaoApto extends Situacao {

    @Override
    public void habilitaCidadao(Cidadao cidadao) {
        EnumSituacoes situacao = EnumSituacoes.APTO_PRIMEIRA_DOSE;
        cidadao.setSituacao(situacao);

    }

    @Override
    public void atualizaSituacao(Cidadao cidadao, Integer dosesNecessarias) {
    }

    @Override
    public String toString() {
        return "Não Apto";
    }


}
