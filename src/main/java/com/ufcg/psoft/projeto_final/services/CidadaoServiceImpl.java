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

        Date dataNascimento = new SimpleDateFormat("dd/MM/yyyy").parse(cidadaoDTO.getDataNascimento());

        Cidadao novoCidadao = new Cidadao(cidadaoDTO.getNomeCompleto(), cidadaoDTO.getEndereco(),
                cidadaoDTO.getCpf(), cidadaoDTO.getCartaoSus(), cidadaoDTO.getEmail(), dataNascimento,
                cidadaoDTO.getTelefone(), cidadaoDTO.getProfissao(), cidadaoDTO.getComorbidades());


        cidadaoRepository.save(novoCidadao);
        return loginCidadaoService.criaLoginCidadao(novoCidadao);
    
    }


    @Override
    public Cidadao getCidadao(Long cpf) {
        return cidadaoRepository.findById(cpf).get(); //TODO REFATORAR!!
    }

//    @Override
//    public EnumSituacoes getSituacao(Long cpf) {
//        Cidadao cidadao = this.getCidadao(cpf);
//        EnumSituacoes situacao = cidadao.getSituacao();
//        return situacao;
//    }

    @Override
    public Cidadao atualizaCadastro(Long cpf, AtualizaCidadaoDTO atualizaCidadaoDTO) {

        Cidadao cidadao = this.getCidadao(cpf);

        cidadao.setProfissao(atualizaCidadaoDTO.getProfissao());
        cidadao.setNome(atualizaCidadaoDTO.getNomeCompleto());
        cidadao.setEndereco(atualizaCidadaoDTO.getEndereco());
        cidadao.setTelefone(atualizaCidadaoDTO.getTelefone());
        cidadao.setComorbidades(atualizaCidadaoDTO.getComorbidades());

        cidadaoRepository.save(cidadao);

        return cidadao;
    }
}
