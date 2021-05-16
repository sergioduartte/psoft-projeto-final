package com.ufcg.psoft.projeto_final.services;

import com.ufcg.psoft.projeto_final.DTOs.AtualizaCidadaoDTO;
import com.ufcg.psoft.projeto_final.DTOs.CidadaoDTO;
import com.ufcg.psoft.projeto_final.entidades.*;
import com.ufcg.psoft.projeto_final.erro.LoginTipoInvalido;

import java.text.ParseException;
import java.util.Optional;

import org.springframework.stereotype.Service;


@Service
public interface CidadaoService {
	
	LoginCidadao save(CidadaoDTO cidadaoDTO) throws ParseException, LoginTipoInvalido;

	public Cidadao getCidadao(Long cpf);

	Cidadao atualizaCadastro(Long cpf, AtualizaCidadaoDTO atualizaCidadaoDTO);
}
