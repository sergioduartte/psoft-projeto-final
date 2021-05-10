package com.ufcg.psoft.projeto_final.services;

import com.ufcg.psoft.projeto_final.DTOs.VacinaDTO;
import com.ufcg.psoft.projeto_final.entidades.Vacina;
import org.springframework.stereotype.Service;


@Service
public interface VacinaService {
    
	Vacina criaTipoVacina(VacinaDTO vacinaDTO);

}
