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

@Service
public class CidadaoServiceImpl implements CidadaoService {
	
	@Autowired
    CidadaoRepository cidadaoRepository;

    @Autowired
    LoginCidadaoService loginCidadaoService;

    @Override
    public LoginCidadao save (InsereCidadaoDTO insereCidadaoDTO) throws ParseException, LoginTipoInvalido {
    	
        Date dataNascimento = new SimpleDateFormat("yyyy-MM-dd").parse(insereCidadaoDTO.getDataNascimento());
        
        Cidadao novoCidadao = new Cidadao(insereCidadaoDTO.getNomeCompleto(), insereCidadaoDTO.getEndereco(),
        		insereCidadaoDTO.getCpf(), insereCidadaoDTO.getCartaoSus(), insereCidadaoDTO.getEmail(), dataNascimento,
        		insereCidadaoDTO.getTelefone(), insereCidadaoDTO.getProfissao(), insereCidadaoDTO.getCormobidades());

        cidadaoRepository.save(novoCidadao);
        return loginCidadaoService.criaLoginCidadao(novoCidadao);
    
    }

//    @Autowired
//   private CidadaoRepository cidadaoRepository;

//    @Override
//    public Cidadao adicionaCidadao(Cidadao cidadao) {
//        Cidadao novoCidadao = new Cidadao(cidadao.getNome(), cidadao.getEndereco(), cidadao.getCpf(), cidadao.getNumeroSUS(),
//                cidadao.getEmail(), cidadao.getDataNascimento().toString(), cidadao.getTelefone(), cidadao.getProfissao()); //TODO, cidadao.getComorbidades().toString());
//        cidadaoRepository.save(cidadao);

//        return novoCidadao;
//    }

//    @Override
//    public Optional<Cidadao> getCidadao(String cpf) {
//        return cidadaoRepository.findByCpf(cpf);
//    }
	
}
