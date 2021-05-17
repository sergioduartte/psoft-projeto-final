package com.ufcg.psoft.projeto_final.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.ufcg.psoft.projeto_final.models.RegistroVacinacao;

@Repository
public interface RegistroVacinacaoRepository  extends JpaRepository<RegistroVacinacao, String>{
	
}
