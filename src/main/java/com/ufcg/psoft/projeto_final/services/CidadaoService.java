package com.ufcg.psoft.projeto_final.services;

import com.ufcg.psoft.projeto_final.DTOs.InsereCidadaoDTO;
import com.ufcg.psoft.projeto_final.entidades.*;
import com.ufcg.psoft.projeto_final.erro.LoginTipoInvalido;

import java.text.ParseException;
import org.springframework.stereotype.Service;


@Service
public interface CidadaoService {
	
	LoginCidadao save(InsereCidadaoDTO insereCidadaoDTO) throws ParseException, LoginTipoInvalido;

	//public Cidadao adicionaCidadao(Cidadao cidadao);
	//public Set<Cidadao> getCidadaos();
	//public Optional<Cidadao> getCidadao(String cpf);
	//public void adicionaUsuario(Cidadao cidadao);
	//public void removeUsuario(Cidadao cidadao);
	
}
