package com.ufcg.psoft.projeto_final.repositories;

import com.ufcg.psoft.projeto_final.models.Vacina;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VacinaRepository extends JpaRepository<Vacina, Long> {
}