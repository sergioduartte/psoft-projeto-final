package com.ufcg.psoft.projeto_final.models.situacoes;

import com.ufcg.psoft.projeto_final.models.Cidadao;

public class NaoApto extends Situacao{

	@Override
	public String habilitaCidadao(Cidadao cidadao) {
		EnumSituacoes situacao = EnumSituacoes.APTO_PRIMEIRA_DOSE;
		cidadao.setSituacao(situacao);
		
		return ""; // TODO "O cidadão de cpf " + cidadao.getCpf() + " agora está apto para a primeira dose da vacina.";
	}

	@Override
	public String atualizaSituacao(Cidadao cidadao, Integer dosesNecessarias) {
		 return ""; // TODO "O cidadão de cpf " + cidadao.getCpf() + "não está apto para a vacinação";
	}

	@Override
	public String toString() {
		return "Não Apto";
	}
	

}
