package com.ufcg.psoft.projeto_final.models.situacoes;

import com.ufcg.psoft.projeto_final.models.Cidadao;


public class AptoPrimeiraDose  extends Situacao{

	@Override
	public String habilitaCidadao(Cidadao cidadao) {
		 return ""; // TODO ""O cidadão de CPF "+ cidadao.getCpf() +" não pode passar para a próxima fase  da vacinação sem ter tomado a primeira dose da vacina.";
	}

	@Override
	public String atualizaSituacao(Cidadao cidadao, Integer dosesNecessarias) {
		 if(dosesNecessarias == 2){
	            EnumSituacoes situacao = EnumSituacoes.ESPERANDO_SEGUNDA_DOSE;
	            cidadao.setSituacao(situacao);
	        }else{
	            EnumSituacoes situacao = EnumSituacoes.VACINACAO_FINALIZADA;
	            cidadao.setSituacao(situacao);
	        }
	        
	        return ""; // TODO "O cidadão de cpf "+ cidadao.getCpf() + " tomou a primeira dose da vacina.";
	    }

	@Override
	public String toString() {
		return "Apto Primeira Dose";
	}

}


