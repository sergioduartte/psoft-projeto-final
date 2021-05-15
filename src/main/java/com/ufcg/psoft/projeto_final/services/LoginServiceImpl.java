package com.ufcg.psoft.projeto_final.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ufcg.psoft.projeto_final.DTOs.*;
import com.ufcg.psoft.projeto_final.entidades.*;
import com.ufcg.psoft.projeto_final.erro.*;
import com.ufcg.psoft.projeto_final.repository.*;
import com.ufcg.psoft.projeto_final.util.LoginUtil;
import com.ufcg.psoft.projeto_final.web_security.AuthTokenService;

/**
 * falta fazer o  e autenticacao
 * @author mort4
 *
 */
@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    LoginRepository loginRepository;

    @Autowired
    LoginTipoService loginTipoService;
    
    @Autowired
    AuthTokenService authTokenService;

    @Override
    public Login criaLogin(String login, String loginTipo) throws LoginTipoInvalido {
        
    	LoginTipo loginTipoEncontrado = loginTipoService.findByLoginTipo(loginTipo);
        Login novoLogin = new Login(login, LoginUtil.geraSenha(), loginTipoEncontrado);
        loginRepository.save(novoLogin);
        
        return novoLogin;
    }
    

    @Override
    public String login(LoginDTO loginDTO) throws LoginInvalido {
        
    	Optional<Login> loginEncontrado = loginRepository.findByLoginAndPassword(loginDTO.getLogin(), loginDTO.getSenha());

        if (!loginEncontrado.isPresent()) {
            throw new LoginInvalido();
        }

        return authTokenService.createAuthToken(loginDTO.getLogin());
        
    }

    @Override
    public Login findByUserLogin(String login) {
        Optional<Login> loginEncontrado = loginRepository.findByLogin(login);
        return loginEncontrado.orElse(null);
    }
    
}