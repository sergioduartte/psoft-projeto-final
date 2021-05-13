package com.ufcg.psoft.projeto_final.entidades.situacoes;

public enum EnumSituacoes {
	 	NAO_APTO(new NaoApto()),
	    APTO_PRIMEIRA_DOSE(new AptoPrimeiraDose()),
	    TOMOU_PRIMEIRA_DOSE(new TomouPrimeiraDose()),
	    APTO_SEGUNDA_DOSE_(new AptoSegundaDose()),
	    VACINACAO_FINALIZADA(new VacinacaoFinalizada());

	    private Situacao situacao;
	    private EnumSituacoes(Situacao situacao){
	        this.situacao = situacao;
	    }
	    
	    public Situacao getSituacao() {
	        return situacao;
	    }
	    
}


