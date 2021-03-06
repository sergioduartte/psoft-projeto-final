package com.ufcg.psoft.projeto_final.services.login;

import com.ufcg.psoft.projeto_final.DTOs.LoginDTO;
import com.ufcg.psoft.projeto_final.errors.LoginInvalido;
import com.ufcg.psoft.projeto_final.errors.LoginTipoInvalido;
import com.ufcg.psoft.projeto_final.models.Login;
import com.ufcg.psoft.projeto_final.models.LoginTipo;
import com.ufcg.psoft.projeto_final.repositories.LoginRepository;
import com.ufcg.psoft.projeto_final.web_security.JwtTokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    LoginRepository loginRepository;

    @Autowired
    LoginTipoService loginTipoService;

    @Autowired
    JwtTokenService authTokenService;

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

    @Override
    public void habilitaFuncionario(String login) throws LoginTipoInvalido {

        LoginTipo loginTipoEncontrado = loginTipoService.findByLoginTipo("FUNCIONARIO");

        Optional<Login> loginEncontrado = loginRepository.findByLogin(login);

        if (loginEncontrado.isPresent()) {
            loginEncontrado.get().setLoginTipo(loginTipoEncontrado);
        }

    }


}