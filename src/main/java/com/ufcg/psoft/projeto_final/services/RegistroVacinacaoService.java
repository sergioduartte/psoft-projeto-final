package com.ufcg.psoft.projeto_final.services;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.ufcg.psoft.projeto_final.entidades.RegistroVacinacao;

@Service
public interface RegistroVacinacaoService {
	void salvar(RegistroVacinacao registroVacinacao);
	public Optional<RegistroVacinacao> getById(String cpf);
}
