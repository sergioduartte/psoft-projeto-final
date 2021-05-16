package com.ufcg.psoft.projeto_final.services;

import com.ufcg.psoft.projeto_final.entidades.Cidadao;
import com.ufcg.psoft.projeto_final.entidades.Login;
import com.ufcg.psoft.projeto_final.erro.LoginTipoInvalido;

public interface LoginCidadaoService {
    
	Login criaLoginCidadao(Cidadao cidadao) throws LoginTipoInvalido;

}
