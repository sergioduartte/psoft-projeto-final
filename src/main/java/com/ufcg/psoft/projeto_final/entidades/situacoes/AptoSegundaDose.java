package com.ufcg.psoft.projeto_final.entidades.situacoes;

import com.ufcg.psoft.projeto_final.entidades.Cidadao;
import com.ufcg.psoft.projeto_final.entidades.Vacina;


public class AptoSegundaDose extends Situacao{

	@Override
	public String atualizaSituacao(Cidadao cidadao) {
		 return "O cidadão de cpf "+ cidadao.getCpf() + " não pode passar para a próxima fase da vacinação sem ter tomado a segunda dose da vacina";
	}

	@Override
	public String tomaVacina(Cidadao cidadao, Vacina vacina) {
		EnumSituacoes situacao = EnumSituacoes.VACINACAO_FINALIZADA;
        cidadao.setSituacao(situacao);
        return "O cidadão de cpf " + cidadao.getCpf() + " tomou a segunda dose da vacina";
	}

	@Override
	public String toString() {
		return "Apto Segunda Dose ";
	}
	
}