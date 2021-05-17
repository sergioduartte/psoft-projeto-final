package com.ufcg.psoft.projeto_final.models.situacoes;

import com.ufcg.psoft.projeto_final.models.Cidadao;

public class VacinacaoFinalizada extends Situacao {

    @Override
    public void habilitaCidadao(Cidadao cidadao) {
    }

    @Override
    public void atualizaSituacao(Cidadao cidadao, Integer dosesNecessarias) {
    }

    @Override
    public String toString() {
        return "O cidadão já finalizou o seu processo de vacinação, VIVA O SUS!";
    }

}
