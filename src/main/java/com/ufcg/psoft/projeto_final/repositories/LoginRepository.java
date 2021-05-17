package com.ufcg.psoft.projeto_final.repositories;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.ufcg.psoft.projeto_final.models.Login;

public interface LoginRepository extends JpaRepository<Login, Long> {
	
	Optional<Login> findByLogin(String login);
    Optional<Login> findByLoginAndPassword(String login, String password);
       
}
