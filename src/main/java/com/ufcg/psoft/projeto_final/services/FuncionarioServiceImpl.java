package com.ufcg.psoft.projeto_final.services;

import com.ufcg.psoft.projeto_final.DTOs.FuncionarioDTO;
import com.ufcg.psoft.projeto_final.entidades.Cidadao;
import com.ufcg.psoft.projeto_final.entidades.Funcionario;
import com.ufcg.psoft.projeto_final.entidades.LoginFuncionario;
import com.ufcg.psoft.projeto_final.entidades.situacoes.EnumSituacoes;
import com.ufcg.psoft.projeto_final.erro.ErroCidadao;
import com.ufcg.psoft.projeto_final.repository.CidadaoRepository;
import com.ufcg.psoft.projeto_final.repository.FuncionarioAnaliseRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class FuncionarioServiceImpl implements  FuncionarioService {

    @Autowired
    CidadaoService cidadaoService;

    @Autowired
    FuncionarioAnaliseRepository funcionarioAnaliseRepository;
    @Autowired
    CidadaoRepository cidadaoRepository;
   

    @Override
    public ResponseEntity<?> save(FuncionarioDTO funcionario) {
        Cidadao cidadao = cidadaoService.getCidadao(funcionario.getCpf());

        if (cidadao !=null) {
             return ErroCidadao.cidadaoInexistente(funcionario.getCpf());
        }

        Funcionario novoFuncionario = new Funcionario(cidadao, funcionario.getCargo(),
                funcionario.getLocalTrabalho());

        funcionarioAnaliseRepository.save(novoFuncionario);

        return new ResponseEntity<>(novoFuncionario, HttpStatus.CREATED);
    }

	@Override
	public Cidadao habilita(Long id) {
		Cidadao cidadao = cidadaoRepository.getOne(id);
		
    	EnumSituacoes situacao = cidadao.getSituacao();
    	EnumSituacoes novaSituacao;
    	if(situacao.equals(EnumSituacoes.NAO_APTO)) {
    		novaSituacao = EnumSituacoes.APTO_PRIMEIRA_DOSE;

    	}else if(situacao.equals(EnumSituacoes.TOMOU_PRIMEIRA_DOSE)){
    		 novaSituacao = EnumSituacoes.APTO_SEGUNDA_DOSE;

    	}else if(situacao.equals(EnumSituacoes.VACINACAO_FINALIZADA)){
    		novaSituacao = situacao;
    	
    	}else {
    		novaSituacao = situacao;
    		
    	}
    	cidadao.setSituacao(novaSituacao);
    	cidadaoRepository.save(cidadao);
    	return cidadao;
	}

	@Override
	public List<Cidadao> habilitaPorIdade(Integer idadeMinima) {
    	// TODO checar se a idade minima eh maior que 0
		List<Cidadao> cidadaos = cidadaoRepository.findAll();
		List<Cidadao> habilitados = new ArrayList<>();
		for (Cidadao cidadao: cidadaos) {
			if (idadeMinima.compareTo(cidadao.getIdade()) <=0 ) {
				habilitados.add(habilita(cidadao.getId()));
			}
		}
		return habilitados;
	}

	@Override
	public List<Cidadao> habilitaPorComorbidade(String comorbidade) {
		List<Cidadao> cidadaos = cidadaoRepository.findAll();
		List<Cidadao> habilitados = new ArrayList<>();
		for (Cidadao cidadao: cidadaos) {
			if (cidadao.getComorbidades().contains(comorbidade) ) {
				habilitados.add(habilita(cidadao.getId()));
			}
		}
		return habilitados;
	}

	@Override
	public List<Cidadao> habilitaPorProfissao(String profissao) {
		List<Cidadao> cidadaos = cidadaoRepository.findAll();
		List<Cidadao> habilitados = new ArrayList<>();
		for (Cidadao cidadao: cidadaos) {
			if (cidadao.getProfissao().equals(profissao) ) {
				habilitados.add(habilita(cidadao.getId()));
			}
		}
		return habilitados;
	}
}
