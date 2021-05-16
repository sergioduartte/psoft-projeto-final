package com.ufcg.psoft.projeto_final.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ufcg.psoft.projeto_final.entidades.*;
import com.ufcg.psoft.projeto_final.erro.LoginTipoInvalido;
import com.ufcg.psoft.projeto_final.repository.LoginCidadaoRepository;

@Service
public class LoginCidadaoServiceImpl implements LoginCidadaoService {

    @Autowired
    LoginService loginService;

    @Autowired
    LoginCidadaoRepository loginCidadaoRepository;

    @Override
    public Login criaLoginCidadao(Cidadao cidadao) throws LoginTipoInvalido {
        Login novoLogin = loginService.criaLogin(cidadao.getCpf(), "CIDADAO");
//        LoginCidadao novoLoginCidadao = new LoginCidadao(novoLogin, cidadao);
//        loginCidadaoRepository.save(novoLoginCidadao);
        return novoLogin;
    }
}