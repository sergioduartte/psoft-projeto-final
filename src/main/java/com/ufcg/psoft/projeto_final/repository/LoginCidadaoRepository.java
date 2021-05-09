package com.ufcg.psoft.projeto_final.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.ufcg.psoft.projeto_final.entidades.LoginCidadao;

public interface LoginCidadaoRepository extends JpaRepository<LoginCidadao, Long> {

	Optional<LoginCidadao> findByLogin(String login);

}
