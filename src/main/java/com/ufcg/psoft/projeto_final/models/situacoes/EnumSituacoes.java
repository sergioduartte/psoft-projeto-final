package com.ufcg.psoft.projeto_final.models.situacoes;

public enum EnumSituacoes {
    NAO_APTO(new NaoApto()),
    APTO_PRIMEIRA_DOSE(new AptoPrimeiraDose()),
    ESPERANDO_SEGUNDA_DOSE(new EsperandoSegundaDose()),
    APTO_SEGUNDA_DOSE(new AptoSegundaDose()),
    VACINACAO_FINALIZADA(new VacinacaoFinalizada());

    private final Situacao situacao;

    EnumSituacoes(Situacao situacao) {
        this.situacao = situacao;
    }

    public Situacao getSituacao() {
        return situacao;
    }

}


