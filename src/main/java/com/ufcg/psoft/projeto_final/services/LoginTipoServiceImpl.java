package com.ufcg.psoft.projeto_final.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ufcg.psoft.projeto_final.entidades.LoginTipo;
import com.ufcg.psoft.projeto_final.erro_login.LoginTipoInvalido;
import com.ufcg.psoft.projeto_final.repository.LoginTipoRepository;

@Service
public class LoginTipoServiceImpl implements LoginTipoService {

    @Autowired
    LoginTipoRepository loginTipoRepository;

    @Override
    public LoginTipo findByLoginTipo(String loginTipo) throws LoginTipoInvalido {
        
    	Optional<LoginTipo> loginTipoEncontrado = loginTipoRepository.findByLoginTipo(loginTipo);

        if (loginTipoEncontrado.isPresent()) {
        	return loginTipoEncontrado.get();            
        } else {
        	throw new LoginTipoInvalido(loginTipo);
        }        
    }
    
}
