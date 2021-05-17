package com.ufcg.psoft.projeto_final.repositories;

import com.ufcg.psoft.projeto_final.models.Lote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoteRepository extends JpaRepository<Lote, Long> {

}
