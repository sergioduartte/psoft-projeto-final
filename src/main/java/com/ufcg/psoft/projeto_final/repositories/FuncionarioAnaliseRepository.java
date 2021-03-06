package com.ufcg.psoft.projeto_final.repositories;

import com.ufcg.psoft.projeto_final.models.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FuncionarioAnaliseRepository extends JpaRepository<Funcionario, Long> {

    @Query("SELECT f FROM Funcionario f WHERE f.cidadao = (SELECT c FROM Cidadao c WHERE c.cpf = :cpf)")
    Optional<Funcionario> findByCpf(@Param("cpf") Long cpf);
}
