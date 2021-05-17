package com.ufcg.psoft.projeto_final.services;

import com.ufcg.psoft.projeto_final.DTOs.*;
import com.ufcg.psoft.projeto_final.entidades.*;
import com.ufcg.psoft.projeto_final.erro.*;
import com.ufcg.psoft.projeto_final.exceptions.CadastroCidadaoException;
import com.ufcg.psoft.projeto_final.exceptions.CidadaoNaoEncontradoException;
import com.ufcg.psoft.projeto_final.repository.*;

import org.hibernate.exception.ConstraintViolationException;
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
    LoginService loginService;

    @Override
    public Cidadao saveCidadao (CidadaoDTO cidadaoDTO) throws LoginTipoInvalido, CidadaoCadastroInvalido {
        Date dataNascimento;
        Cidadao novoCidadao;

        try {
            dataNascimento = new SimpleDateFormat("dd/MM/yyyy").parse(cidadaoDTO.getDataNascimento());
        } catch (ParseException e) {
            throw new CidadaoCadastroInvalido("Data nao esta no formato \"dd/MM/yyyy\"." );
        }

        try {
            novoCidadao = new Cidadao(cidadaoDTO.getNomeCompleto(), cidadaoDTO.getEndereco(),
                    cidadaoDTO.getCpf(), cidadaoDTO.getCartaoSus(), cidadaoDTO.getEmail(), dataNascimento,
                    cidadaoDTO.getTelefone(), cidadaoDTO.getProfissao(), cidadaoDTO.getComorbidades(), cidadaoDTO.getSenha());
        } catch (CadastroCidadaoException e) {
            throw new CidadaoCadastroInvalido(e.getMessage());
        }

        try {
            cidadaoRepository.save(novoCidadao);
            loginService.criaLogin(novoCidadao.getCpf(), novoCidadao.getSenha(), "CIDADAO");
        } catch (ConstraintViolationException e){
            throw new CidadaoCadastroInvalido(e.getMessage());
        }

        return novoCidadao;
    }


    @Override
    public Cidadao getCidadao(Long cpf) throws CidadaoNaoEncontradoException {
        Cidadao c = cidadaoRepository.findById(cpf).get();
        if( c == null){
            throw new CidadaoNaoEncontradoException("");
        }
        return c;
    }

    @Override
    public Cidadao atualizaCadastro(Long cpf, AtualizaCidadaoDTO atualizaCidadaoDTO) throws CidadaoNaoEncontradoException {

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
