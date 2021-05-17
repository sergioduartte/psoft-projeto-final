package com.ufcg.psoft.projeto_final.services.login;

import com.ufcg.psoft.projeto_final.errors.LoginTipoInvalido;
import com.ufcg.psoft.projeto_final.models.LoginTipo;

public interface LoginTipoService {

    LoginTipo findByLoginTipo(String loginTipo) throws LoginTipoInvalido;

}
