package com.example.projeto_final_psoft.daos;

import com.example.projeto_final_psoft.entidades.Vacina;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository
public interface VacinaRepository<T, ID extends Serializable> extends JpaRepository<Vacina, Long> {
}
