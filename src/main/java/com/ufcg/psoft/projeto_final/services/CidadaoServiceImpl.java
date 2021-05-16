package com.ufcg.psoft.projeto_final.services;

import com.ufcg.psoft.projeto_final.DTOs.*;
import com.ufcg.psoft.projeto_final.entidades.*;
import com.ufcg.psoft.projeto_final.erro.*;
import com.ufcg.psoft.projeto_final.repository.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;

@Service
public class CidadaoServiceImpl implements CidadaoService {
	
	@Autowired
    CidadaoRepository cidadaoRepository;

    @Autowired
    LoginCidadaoService loginCidadaoService;

    @Override
    public LoginCidadao save (CidadaoDTO cidadaoDTO) throws ParseException, LoginTipoInvalido {
    	
        Date dataNascimento = new SimpleDateFormat("yyyy-MM-dd").parse(cidadaoDTO.getDataNascimento());
        
        Cidadao novoCidadao = new Cidadao(cidadaoDTO.getNomeCompleto(), cidadaoDTO.getEndereco(),
        		cidadaoDTO.getCpf(), cidadaoDTO.getCartaoSus(), cidadaoDTO.getEmail(), dataNascimento,
        		cidadaoDTO.getTelefone(), cidadaoDTO.getProfissao(), cidadaoDTO.getCormobidades());

        cidadaoRepository.save(novoCidadao);
        return loginCidadaoService.criaLoginCidadao(novoCidadao);
    
    }


//    @Override
//    public Cidadao adicionaCidadao(Cidadao cidadao) {
//        Cidadao novoCidadao = new Cidadao(cidadao.getNome(), cidadao.getEndereco(), cidadao.getCpf(), cidadao.getNumeroSUS(),
//                cidadao.getEmail(), cidadao.getDataNascimento().toString(), cidadao.getTelefone(), cidadao.getProfissao()); //TODO, cidadao.getComorbidades().toString());
//        cidadaoRepository.save(cidadao);

//        return novoCidadao;
//    }

    @Override
    public Cidadao getCidadao(Long cpf) {
        return cidadaoRepository.findById(cpf).get(); //TODO REFATORAR!!
    }
	
}
