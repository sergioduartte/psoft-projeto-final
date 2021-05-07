package com.example.projeto_final_psoft.repositorios;
import com.example.projeto_final_psoft.entidades.Cidadao;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.projeto_final_psoft.entidades.Lote;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface LoteRepository  extends JpaRepository<Lote, Long>{

}
