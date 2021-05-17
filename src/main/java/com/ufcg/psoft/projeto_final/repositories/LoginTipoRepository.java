package com.ufcg.psoft.projeto_final.repositories;

import com.ufcg.psoft.projeto_final.models.LoginTipo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LoginTipoRepository extends JpaRepository<LoginTipo, Long> {

    Optional<LoginTipo> findByLoginTipo(String loginTipo);

}
