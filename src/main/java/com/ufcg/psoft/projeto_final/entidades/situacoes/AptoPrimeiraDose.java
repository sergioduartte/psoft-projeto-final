package com.ufcg.psoft.projeto_final.entidades.situacoes;

import com.ufcg.psoft.projeto_final.entidades.Cidadao;
import com.ufcg.psoft.projeto_final.entidades.Vacina;


public class AptoPrimeiraDose  extends Situacao{

	@Override
	public String atualizaSituacao(Cidadao cidadao) {
		 return "O cidadão de CPF "+ cidadao.getCpf() +" não pode passar para a próxima fase  da vacinação sem ter tomado a primeira dose da vacina.";
	}

	@Override
	public String tomaVacina(Cidadao cidadao, Vacina vacina) {
		 if(vacina.getDosesNecessarias() == 2){
	            EnumSituacoes situacao = EnumSituacoes.TOMOU_PRIMEIRA_DOSE;
	            cidadao.setSituacao(situacao);
	        }else{
	            EnumSituacoes situacao = EnumSituacoes.VACINACAO_FINALIZADA;
	            cidadao.setSituacao(situacao);
	        }
	        
	        return "O cidadão de cpf "+ cidadao.getCpf() + " tomou a primeira dose da vacina.";
	    }

	@Override
	public String toString() {
		return "Apto Primeira Dose";
	}

}


