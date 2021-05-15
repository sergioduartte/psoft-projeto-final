package com.ufcg.psoft.projeto_final.repository;

import com.ufcg.psoft.projeto_final.entidades.Agenda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AgendaRepository extends JpaRepository<Agenda, Long> {
}
