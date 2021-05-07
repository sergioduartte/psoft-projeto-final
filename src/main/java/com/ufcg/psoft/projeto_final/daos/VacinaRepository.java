package com.ufcg.psoft.projeto_final.daos;

import com.ufcg.psoft.projeto_final.entidades.Vacina;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository
public interface VacinaRepository<T, ID extends Serializable> extends JpaRepository<Vacina, Long> {
}
