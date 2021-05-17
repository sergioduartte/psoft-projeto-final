package com.ufcg.psoft.projeto_final.models.situacoes;

import com.ufcg.psoft.projeto_final.models.Cidadao;

public abstract class Situacao {
	
	 Situacao(){};
	 public abstract String habilitaCidadao(Cidadao cidadao);
	 public abstract String atualizaSituacao(Cidadao cidadao, Integer dosesNecessarias);

}
