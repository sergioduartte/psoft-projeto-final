package com.ufcg.psoft.projeto_final.entidades.situacoes;

import com.ufcg.psoft.projeto_final.entidades.Cidadao;
import com.ufcg.psoft.projeto_final.entidades.Vacina;

public abstract class Situacao {
	
	 Situacao(){};
	 public abstract String habilitaCidadao(Cidadao cidadao);
	 public abstract String atualizaSituacao(Cidadao cidadao, Integer dosesNecessarias);

}
