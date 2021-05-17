package com.ufcg.psoft.projeto_final.models.situacoes;

import com.ufcg.psoft.projeto_final.models.Cidadao;

public abstract class Situacao {

    Situacao() {
    }

    public abstract void habilitaCidadao(Cidadao cidadao);

    public abstract void atualizaSituacao(Cidadao cidadao, Integer dosesNecessarias);

}
