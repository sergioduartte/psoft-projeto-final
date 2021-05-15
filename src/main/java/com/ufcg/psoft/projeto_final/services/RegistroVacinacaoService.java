package com.ufcg.psoft.projeto_final.services;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.ufcg.psoft.projeto_final.DTOs.RegistroVacinacaoDTO;
import com.ufcg.psoft.projeto_final.entidades.RegistroVacinacao;

@Service
public interface RegistroVacinacaoService {
	RegistroVacinacao salvar(RegistroVacinacaoDTO registroVacinacaoDTO);
	
}
