package com.ufcg.psoft.projeto_final.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.ufcg.psoft.projeto_final.entidades.LoginTipo;

public interface LoginTipoRepository extends JpaRepository<LoginTipo, Long> {
    
	Optional<LoginTipo> findByLoginTipo(String loginTipo);

}
