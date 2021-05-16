package com.ufcg.psoft.projeto_final;

import com.ufcg.psoft.projeto_final.entidades.Login;
import com.ufcg.psoft.projeto_final.entidades.LoginTipo;
import com.ufcg.psoft.projeto_final.repository.LoginRepository;
import com.ufcg.psoft.projeto_final.repository.LoginTipoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class InitialData {

    @Autowired
    LoginRepository loginRepository;

    @Autowired
    LoginTipoRepository loginTipoRepository;

    @Bean
    public CommandLineRunner loadData() {
        return (args) -> {
            if (!loginTipoRepository.findByLoginTipo("ADMIN").isPresent()){
                loginTipoRepository.save(new LoginTipo(1L, "ADMIN"));
            }
            if (!loginTipoRepository.findByLoginTipo("CIDADAO").isPresent()){
                loginTipoRepository.save(new LoginTipo(2L, "CIDADAO"));
            }
            if (!loginTipoRepository.findByLoginTipo("FUNCIONARIO").isPresent()){
                loginTipoRepository.save(new LoginTipo(3L, "FUNCIONARIO"));
            }
            if (!loginRepository.findByLoginAndPassword("admin", "admin").isPresent()){
                loginRepository.save(new Login(1L, "admin", "admin", loginTipoRepository.findByLoginTipo("ADMIN").get()));
            }

        };
    }

}
