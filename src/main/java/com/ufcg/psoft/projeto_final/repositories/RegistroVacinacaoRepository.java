package com.ufcg.psoft.projeto_final.repositories;

import com.ufcg.psoft.projeto_final.models.RegistroVacinacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegistroVacinacaoRepository extends JpaRepository<RegistroVacinacao, String> {

}
