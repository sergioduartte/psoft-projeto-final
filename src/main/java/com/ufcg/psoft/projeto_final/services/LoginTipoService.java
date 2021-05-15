package com.ufcg.psoft.projeto_final.services;

import com.ufcg.psoft.projeto_final.entidades.LoginTipo;
import com.ufcg.psoft.projeto_final.erro.LoginTipoInvalido;

public interface LoginTipoService {
    
	LoginTipo findByLoginTipo(String loginTipo) throws LoginTipoInvalido;

}
