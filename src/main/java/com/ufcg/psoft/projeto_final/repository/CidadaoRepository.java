package com.ufcg.psoft.projeto_final.repository;

import com.ufcg.psoft.projeto_final.entidades.Cidadao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CidadaoRepository extends JpaRepository<Cidadao, Long> {

    Optional<Cidadao> findByCpf(String cpf);

}
