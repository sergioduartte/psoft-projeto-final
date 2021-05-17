package com.ufcg.psoft.projeto_final.services.vacina;

import com.ufcg.psoft.projeto_final.errors.VacinaCadastroInvalido;
import com.ufcg.psoft.projeto_final.errors.VacinaNaoEncontrada;
import com.ufcg.psoft.projeto_final.exceptions.CadastroVacinaException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ufcg.psoft.projeto_final.DTOs.VacinaDTO;
import com.ufcg.psoft.projeto_final.models.Vacina;
import com.ufcg.psoft.projeto_final.repositories.VacinaRepository;

import java.util.List;
import java.util.Optional;

@Service
public class VacinaServiceImpl implements VacinaService {

	@Autowired
	VacinaRepository vacinaRepository;

	@Override
	public Vacina saveVacina(VacinaDTO vacinaDTO) throws VacinaCadastroInvalido {
		List<Vacina> vacinas = getVacina();
		for (Vacina v : vacinas) {
			if (v.getFabricante().equals(vacinaDTO.getFabricante())) {
				throw new VacinaCadastroInvalido("Vacina do fabricante informado ja cadastrada.");
			}
		}

		Vacina novaVacina;
		try {
			novaVacina = new Vacina(vacinaDTO.getFabricante(), vacinaDTO.getDosesNecessarias(), vacinaDTO.getIntervaloDoses());
		} catch (CadastroVacinaException e){
			throw new VacinaCadastroInvalido(e.getMessage());
		}
		vacinaRepository.save(novaVacina);
		return novaVacina;
	}

	@Override
	public List<Vacina> getVacina() {
		return vacinaRepository.findAll();
	}

	@Override
	public Vacina getVacinaById(Long id) throws VacinaNaoEncontrada {
		Optional<Vacina> vacinaEncontrada = vacinaRepository.findById(id);
		if (!vacinaEncontrada.isPresent()){
			throw new VacinaNaoEncontrada(id);
		}
		return vacinaRepository.findById(id).get();
	}
}

