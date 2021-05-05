package com.example.projeto_final_psoft.repositorios;

import com.example.projeto_final_psoft.entidades.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FuncionarioAnaliseRepository extends JpaRepository<Funcionario, Long> {
}
