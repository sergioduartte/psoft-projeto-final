package com.ufcg.psoft.projeto_final.models.situacoes;

import com.ufcg.psoft.projeto_final.models.Cidadao;

public class EsperandoSegundaDose extends Situacao {

	@Override
	public String habilitaCidadao(Cidadao cidadao) {
		EnumSituacoes situacao = EnumSituacoes.ESPERANDO_SEGUNDA_DOSE;
		cidadao.setSituacao(situacao);
		return ""; // TODO "O cidadão de cpf "+ cidadao.getCpf() + " agora se encontra apto para tomar a segunda dose da vacina";
	}

	@Override
	public String atualizaSituacao(Cidadao cidadao, Integer dosesNecessarias) {
		 return ""; // TODO "O cidadão de cpf " + cidadao.getCpf() + " ainda não está apto para tomar a segunda dose da vacina ";
	}
	
	@Override
    public String toString(){
        return "Esperando segunda dose";
    }

}
