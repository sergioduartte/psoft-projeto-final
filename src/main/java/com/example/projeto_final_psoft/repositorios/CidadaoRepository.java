package com.example.projeto_final_psoft.repositorios;

import com.example.projeto_final_psoft.entidades.Cidadao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CidadaoRepository extends JpaRepository<Cidadao, Long> {

    Optional<Cidadao> findByCpf(String cpf);

}
