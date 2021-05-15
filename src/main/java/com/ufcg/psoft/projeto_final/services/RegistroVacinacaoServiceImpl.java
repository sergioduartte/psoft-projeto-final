package com.ufcg.psoft.projeto_final.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ufcg.psoft.projeto_final.DTOs.RegistroVacinacaoDTO;
import com.ufcg.psoft.projeto_final.entidades.RegistroVacinacao;
import com.ufcg.psoft.projeto_final.repository.CidadaoRepository;
import com.ufcg.psoft.projeto_final.repository.RegistroVacinacaoRepository;

@Service
public class RegistroVacinacaoServiceImpl implements RegistroVacinacaoService{
	
	@Autowired
	RegistroVacinacaoRepository registroVacinacaoRepository;
	@Autowired
	CidadaoRepository cidadaoRepository;
	

	@Override
    public RegistroVacinacao salvar(RegistroVacinacaoDTO registroVacinacaoDTO) {
		
		RegistroVacinacao novoRegistro = new RegistroVacinacao(registroVacinacaoDTO.getCpfCidadao(),registroVacinacaoDTO.getIdVacina(),registroVacinacaoDTO.getDataAplicacao());
        //TODO checar se o registro eh valido
		//TODO checar se ele estava agendado p o dia 
		//TODO alterar os estados do cidadao
		//TODO isvacinaDisponivel??
		registroVacinacaoRepository.save(novoRegistro);
		return novoRegistro;
        
    }

}
