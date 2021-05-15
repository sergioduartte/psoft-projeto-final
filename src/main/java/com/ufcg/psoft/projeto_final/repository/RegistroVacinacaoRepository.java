package com.ufcg.psoft.projeto_final.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.ufcg.psoft.projeto_final.entidades.RegistroVacinacao;

@Repository
public interface RegistroVacinacaoRepository  extends JpaRepository<RegistroVacinacao, String>{
	
}
