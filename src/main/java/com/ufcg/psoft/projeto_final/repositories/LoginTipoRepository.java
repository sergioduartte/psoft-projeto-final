package com.ufcg.psoft.projeto_final.repositories;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.ufcg.psoft.projeto_final.models.LoginTipo;

public interface LoginTipoRepository extends JpaRepository<LoginTipo, Long> {
    
	Optional<LoginTipo> findByLoginTipo(String loginTipo);

}
