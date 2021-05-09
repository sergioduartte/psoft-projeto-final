package com.ufcg.psoft.projeto_final.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ufcg.psoft.projeto_final.DTOs.VacinaDTO;
import com.ufcg.psoft.projeto_final.entidades.Vacina;
import com.ufcg.psoft.projeto_final.repository.VacinaRepository;

@Service
public class VacinaServiceImpl implements VacinaService{
	
	@Autowired
	VacinaRepository vacinaRepository;
	
	@Override
	public Vacina criaTipoVacina(VacinaDTO vacinaDTO) {
		Vacina novaVacina = new Vacina(vacinaDTO.getFabricante(), vacinaDTO.getDosesNecessarias(), vacinaDTO.getIntervaloDoses());
		vacinaRepository.save(novaVacina);
		return novaVacina;
	}


}

