package com.ufcg.psoft.projeto_final.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ufcg.psoft.projeto_final.entidades.RegistroVacinacao;

@Repository
public interface RegistroVacinacaoRepository  extends JpaRepository<RegistroVacinacao, String>{
	
	public Optional<RegistroVacinacao> getByCpfCidadao(String cpf);

    public List<RegistroVacinacao> findByVacinaId(Long id);
}
