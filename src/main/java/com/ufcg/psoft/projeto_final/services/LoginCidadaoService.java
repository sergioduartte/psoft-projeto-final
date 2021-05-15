package com.ufcg.psoft.projeto_final.services;

import com.ufcg.psoft.projeto_final.entidades.Cidadao;
import com.ufcg.psoft.projeto_final.entidades.LoginCidadao;
import com.ufcg.psoft.projeto_final.erro.LoginTipoInvalido;

public interface LoginCidadaoService {
    
	LoginCidadao criaLoginCidadao(Cidadao cidadao) throws LoginTipoInvalido;

}
