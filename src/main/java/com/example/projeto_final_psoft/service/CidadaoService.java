package com.example.projeto_final_psoft.service;

//import java.util.Optional;
//import java.util.Set;

import com.example.projeto_final_psoft.entidades.Cidadao;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface CidadaoService {
	
	public Cidadao adicionaCidadao(Cidadao cidadao);
	//public Set<Cidadao> getCidadaos();
	public Optional<Cidadao> getCidadao(String cpf);
	//public void adicionaUsuario(Cidadao cidadao);
	//public void removeUsuario(Cidadao cidadao);
	
}
