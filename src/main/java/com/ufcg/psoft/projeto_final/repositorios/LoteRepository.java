package com.ufcg.psoft.projeto_final.repositorios;
import com.ufcg.psoft.projeto_final.entidades.Lote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoteRepository  extends JpaRepository<Lote, Long>{

}
