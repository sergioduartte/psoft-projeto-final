package com.ufcg.psoft.projeto_final.services;

import com.ufcg.psoft.projeto_final.entidades.*;
import com.ufcg.psoft.projeto_final.erro.LoginInvalido;
import com.ufcg.psoft.projeto_final.erro.LoginTipoInvalido;
import com.ufcg.psoft.projeto_final.DTOs.*;

public interface LoginService {
	
    Login criaLogin(Long login, String loginTipo) throws LoginTipoInvalido;
    LoginResponse login(LoginDTO loginDTO) throws LoginInvalido;
    Login findByUserLogin(String login);
    
}
