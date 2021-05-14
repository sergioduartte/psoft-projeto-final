package com.ufcg.psoft.projeto_final.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ufcg.psoft.projeto_final.entidades.Vacina;
import org.springframework.stereotype.Repository;

@Repository
public interface VacinaRepository extends JpaRepository<Vacina, Long>{}