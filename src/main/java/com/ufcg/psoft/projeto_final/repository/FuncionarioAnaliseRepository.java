package com.ufcg.psoft.projeto_final.repository;

import com.ufcg.psoft.projeto_final.entidades.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FuncionarioAnaliseRepository extends JpaRepository<Funcionario, Long> {
}
