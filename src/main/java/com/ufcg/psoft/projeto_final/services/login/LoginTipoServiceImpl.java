package com.ufcg.psoft.projeto_final.services.login;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ufcg.psoft.projeto_final.models.LoginTipo;
import com.ufcg.psoft.projeto_final.errors.LoginTipoInvalido;
import com.ufcg.psoft.projeto_final.repositories.LoginTipoRepository;

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
