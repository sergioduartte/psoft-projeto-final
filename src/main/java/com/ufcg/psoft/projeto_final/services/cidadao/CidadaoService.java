package com.ufcg.psoft.projeto_final.services.cidadao;

import com.ufcg.psoft.projeto_final.DTOs.AtualizaCidadaoDTO;
import com.ufcg.psoft.projeto_final.DTOs.CidadaoDTO;
import com.ufcg.psoft.projeto_final.models.*;
import com.ufcg.psoft.projeto_final.errors.CidadaoCadastroInvalido;
import com.ufcg.psoft.projeto_final.errors.LoginTipoInvalido;

import com.ufcg.psoft.projeto_final.exceptions.CidadaoNaoEncontradoException;
import org.springframework.stereotype.Service;


@Service
public interface CidadaoService {
	
	public Cidadao saveCidadao(CidadaoDTO cidadaoDTO) throws LoginTipoInvalido, CidadaoCadastroInvalido;

	public Cidadao getCidadao(Long cpf) throws CidadaoNaoEncontradoException;

	public Cidadao atualizaCadastro(Long cpf, AtualizaCidadaoDTO atualizaCidadaoDTO) throws CidadaoNaoEncontradoException;
}
