package com.ufcg.psoft.projeto_final.models.situacoes;

import com.ufcg.psoft.projeto_final.models.Cidadao;

public class VacinacaoFinalizada extends Situacao {

	@Override
	public String habilitaCidadao(Cidadao cidadao) {
		return ""; // TODO "O cidadão de cpf " + cidadao.getCpf() + " já finalizou o seu processo de vacinação, VIVA O SUS!";
	}

	@Override
	public String atualizaSituacao(Cidadao cidadao, Integer dosesNecessarias) {
		return ""; // TODO "O cidadão de cpf " + cidadao.getCpf() + " já finalizou o seu processo de vacinação, VIVA O SUS!";
	}

	@Override
	public String toString() {
		return "Vacinação Finalizada";
	}

}
