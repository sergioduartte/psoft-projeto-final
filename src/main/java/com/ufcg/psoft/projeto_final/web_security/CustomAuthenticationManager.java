package com.ufcg.psoft.projeto_final.web_security;

import com.ufcg.psoft.projeto_final.models.Login;
import com.ufcg.psoft.projeto_final.services.login.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Service;

@Service
public class CustomAuthenticationManager implements AuthenticationManager {

    @Autowired
    private LoginService loginService;


    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String userLogin = authentication.getName();
        String password = authentication.getCredentials().toString();

        Login login;
        try {
            login = loginService.findByUserLogin(userLogin);

            boolean matchPassword = password.equals(login.getSenha());

            if (matchPassword) {
                return new UsernamePasswordAuthenticationToken(login.getId(), password);
            }

            return null;
        } catch (Exception e) {
            throw new BadCredentialsException("Não existe usuário com esse email");
        }
    }
}
