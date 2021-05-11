package com.ufcg.psoft.projeto_final.repository;

import com.ufcg.psoft.projeto_final.entidades.Cidadao;
import com.ufcg.psoft.projeto_final.entidades.Comorbidade;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ComorbidadeRepository extends JpaRepository<Comorbidade, Long> {
    Optional<Comorbidade> findByDescricao(String descricao);

}
