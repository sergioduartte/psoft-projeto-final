package com.ufcg.psoft.projeto_final.services;

import java.util.Optional;

import com.ufcg.psoft.projeto_final.web_security.JwtTokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ufcg.psoft.projeto_final.DTOs.*;
import com.ufcg.psoft.projeto_final.entidades.*;
import com.ufcg.psoft.projeto_final.erro.*;
import com.ufcg.psoft.projeto_final.repository.*;



@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    LoginRepository loginRepository;

    @Autowired
    LoginTipoService loginTipoService;

    @Autowired
    JwtTokenService authTokenService;
    
//    @Autowired
//    AuthTokenService authTokenService;

    @Override
    public Login criaLogin(Long login, String senha, String loginTipo) throws LoginTipoInvalido {
        
    	LoginTipo loginTipoEncontrado = loginTipoService.findByLoginTipo(loginTipo);
        Login novoLogin = new Login(login.toString(), senha, loginTipoEncontrado);
        loginRepository.save(novoLogin);
        
        return novoLogin;
    }
    

    @Override
    public LoginResponse login(LoginDTO loginDTO) throws LoginInvalido {
        
    	Optional<Login> loginEncontrado = loginRepository.findByLoginAndPassword(loginDTO.getLogin(), loginDTO.getSenha());

        if (!loginEncontrado.isPresent()) {
            throw new LoginInvalido();
        }

        return authTokenService.autentica(loginDTO);
        
    }

    @Override
    public Login findByUserLogin(String login) {
        Optional<Login> loginEncontrado = loginRepository.findByLogin(login);
        return loginEncontrado.orElse(null);
    }
    
}
