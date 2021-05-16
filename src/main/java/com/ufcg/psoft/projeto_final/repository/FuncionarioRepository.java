package com.ufcg.psoft.projeto_final.repository;

import com.ufcg.psoft.projeto_final.entidades.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {

}
