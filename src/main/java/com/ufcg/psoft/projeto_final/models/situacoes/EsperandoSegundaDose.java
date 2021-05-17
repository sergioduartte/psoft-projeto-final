package com.ufcg.psoft.projeto_final.models.situacoes;

import com.ufcg.psoft.projeto_final.models.Cidadao;

public class EsperandoSegundaDose extends Situacao {

    @Override
    public void habilitaCidadao(Cidadao cidadao) {
        EnumSituacoes situacao = EnumSituacoes.ESPERANDO_SEGUNDA_DOSE;
        cidadao.setSituacao(situacao);
    }

    @Override
    public void atualizaSituacao(Cidadao cidadao, Integer dosesNecessarias) {
    }

    @Override
    public String toString() {
        return "Esperando segunda dose!";
    }

}
