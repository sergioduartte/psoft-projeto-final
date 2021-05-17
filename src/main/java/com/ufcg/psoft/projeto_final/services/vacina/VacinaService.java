package com.ufcg.psoft.projeto_final.services.vacina;

import com.ufcg.psoft.projeto_final.DTOs.VacinaDTO;
import com.ufcg.psoft.projeto_final.models.Vacina;
import com.ufcg.psoft.projeto_final.errors.VacinaCadastroInvalido;
import com.ufcg.psoft.projeto_final.errors.VacinaNaoEncontrada;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public interface VacinaService {
	Vacina saveVacina(VacinaDTO vacinaDto) throws VacinaCadastroInvalido;
	List<Vacina> getVacina();
	Vacina getVacinaById(Long id) throws VacinaNaoEncontrada;
}
