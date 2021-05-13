package com.ufcg.psoft.projeto_final.entidades.situacoes;

import com.ufcg.psoft.projeto_final.entidades.Cidadao;
import com.ufcg.psoft.projeto_final.entidades.Vacina;

public class NaoApto extends Situacao{

	@Override
	public String atualizaSituacao(Cidadao cidadao) {
		EnumSituacoes situacao = EnumSituacoes.APTO_PRIMEIRA_DOSE;
		cidadao.setSituacao(situacao);
		
		return "O cidadão de cpf " + cidadao.getCpf() + " agora está apto para a primeira dose da vacina."; 
	}

	@Override
	public String tomaVacina(Cidadao cidadao, Vacina vacina) {
		 return "O cidadão de cpf " + cidadao.getCpf() + "não está apto para a vacinação";
	}

	@Override
	public String toString() {
		return "Não Apto";
	}
	

}
