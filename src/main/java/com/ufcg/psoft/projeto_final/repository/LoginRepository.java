package com.ufcg.psoft.projeto_final.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.ufcg.psoft.projeto_final.entidades.Login;

public interface LoginRepository extends JpaRepository<Login, Long> {
	
	Optional<Login> findByLogin(String login);
    Optional<Login> findByLoginAndPassword(String login, String password);
       
}
