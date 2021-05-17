package com.ufcg.psoft.projeto_final.services;

import com.ufcg.psoft.projeto_final.DTOs.AtualizaCidadaoDTO;
import com.ufcg.psoft.projeto_final.DTOs.CidadaoDTO;
import com.ufcg.psoft.projeto_final.entidades.*;
import com.ufcg.psoft.projeto_final.erro.CidadaoCadastroInvalido;
import com.ufcg.psoft.projeto_final.erro.LoginTipoInvalido;

import java.text.ParseException;

import com.ufcg.psoft.projeto_final.exceptions.CidadaoNaoEncontradoException;
import org.springframework.stereotype.Service;


@Service
public interface CidadaoService {

	Cidadao saveCidadao(CidadaoDTO cidadaoDTO) throws LoginTipoInvalido, CidadaoCadastroInvalido;
	Cidadao getCidadao(Long cpf) throws CidadaoNaoEncontradoException;
	Cidadao atualizaCadastro(Long cpf, AtualizaCidadaoDTO atualizaCidadaoDTO) throws CidadaoNaoEncontradoException;

}