package com.ufcg.psoft.projeto_final.repositories;

import com.ufcg.psoft.projeto_final.models.Login;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LoginRepository extends JpaRepository<Login, Long> {

    Optional<Login> findByLogin(String login);

    Optional<Login> findByLoginAndPassword(String login, String password);

}
