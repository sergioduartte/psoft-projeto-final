package com.ufcg.psoft.projeto_final.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ufcg.psoft.projeto_final.entidades.RegistroVacinacao;
import com.ufcg.psoft.projeto_final.repository.RegistroVacinacaoRepository;

@Service
public class RevistroVacinacaoServiceImpl implements RegistroVacinacaoService{
	
	@Autowired
	RegistroVacinacaoRepository registroVacinacaoRepository;
	

	@Override
    public void salvar(RegistroVacinacao registroVacinacao) {
        registroVacinacaoRepository.save(registroVacinacao);
        
    }

    @Override
    public Optional<RegistroVacinacao> getById(String cpf) {
        return registroVacinacaoRepository.getByCpfCidadao(cpf);
    }

}
