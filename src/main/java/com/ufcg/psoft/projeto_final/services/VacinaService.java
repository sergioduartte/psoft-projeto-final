package com.ufcg.psoft.projeto_final.services;

import com.ufcg.psoft.projeto_final.DTOs.VacinaDTO;
import com.ufcg.psoft.projeto_final.entidades.Vacina;
import com.ufcg.psoft.projeto_final.erro.VacinaCadastroInvalido;
import com.ufcg.psoft.projeto_final.erro.VacinaNaoEncontrada;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public interface VacinaService {
	Vacina saveVacina(VacinaDTO vacinaDto) throws VacinaCadastroInvalido;
	List<Vacina> getVacina();
	Optional<Vacina> getVacinaById(Long id) throws VacinaNaoEncontrada;
}
