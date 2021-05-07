package com.example.projeto_final_psoft.repositorios;

import com.example.projeto_final_psoft.entidades.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FuncionarioAnaliseRepository extends JpaRepository<Funcionario, Long> {
}
