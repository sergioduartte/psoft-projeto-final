package com.ufcg.psoft.projeto_final.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ufcg.psoft.projeto_final.models.Vacina;
import org.springframework.stereotype.Repository;

@Repository
public interface VacinaRepository extends JpaRepository<Vacina, Long>{}