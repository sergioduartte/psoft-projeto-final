package com.ufcg.psoft.projeto_final.repository;
import com.ufcg.psoft.projeto_final.entidades.Lote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LoteRepository  extends JpaRepository<Lote, Long>{

}
