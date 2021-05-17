package com.ufcg.psoft.projeto_final.services.login;

import com.ufcg.psoft.projeto_final.models.LoginTipo;
import com.ufcg.psoft.projeto_final.errors.LoginTipoInvalido;

public interface LoginTipoService {
    
	LoginTipo findByLoginTipo(String loginTipo) throws LoginTipoInvalido;

}
