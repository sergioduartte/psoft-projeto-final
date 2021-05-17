package com.ufcg.psoft.projeto_final.services.login;

import com.ufcg.psoft.projeto_final.models.*;
import com.ufcg.psoft.projeto_final.errors.LoginInvalido;
import com.ufcg.psoft.projeto_final.errors.LoginTipoInvalido;
import com.ufcg.psoft.projeto_final.DTOs.*;

public interface LoginService {

    Login criaLogin(Long login, String senha, String loginTipo) throws LoginTipoInvalido;
    LoginResponse login(LoginDTO loginDTO) throws LoginInvalido;
    Login findByUserLogin(String login);
    void habilitaFuncionario(String login) throws LoginTipoInvalido;
}