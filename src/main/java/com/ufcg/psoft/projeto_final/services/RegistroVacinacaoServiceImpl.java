package com.ufcg.psoft.projeto_final.services;

import java.util.Optional;

import com.ufcg.psoft.projeto_final.entidades.Agenda;
import com.ufcg.psoft.projeto_final.entidades.Cidadao;
import com.ufcg.psoft.projeto_final.entidades.Lote;
import com.ufcg.psoft.projeto_final.erro.RegistroInvalido;
import com.ufcg.psoft.projeto_final.repository.AgendaRepository;
import com.ufcg.psoft.projeto_final.repository.LoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ufcg.psoft.projeto_final.DTOs.RegistroVacinacaoDTO;
import com.ufcg.psoft.projeto_final.entidades.RegistroVacinacao;
import com.ufcg.psoft.projeto_final.repository.CidadaoRepository;
import com.ufcg.psoft.projeto_final.repository.RegistroVacinacaoRepository;

@Service
public class RegistroVacinacaoServiceImpl implements RegistroVacinacaoService{
	
	@Autowired
	RegistroVacinacaoRepository registroVacinacaoRepository;
	@Autowired
	CidadaoRepository cidadaoRepository;
	@Autowired
	LoteRepository loteRepository;
	@Autowired
	AgendaRepository agendaRepository;

	@Override
    public RegistroVacinacao saveRegistro(RegistroVacinacaoDTO registroVacinacaoDTO) throws RegistroInvalido {

		Optional<Cidadao> optionalCidadao = cidadaoRepository.findById(registroVacinacaoDTO.getIdCidadao());
		if (!optionalCidadao.isPresent()) {
			throw new RegistroInvalido("Usuario nao encontrado.");
		}
		Cidadao cidadao = optionalCidadao.get();

		Optional<Agenda> optionalAgenda = agendaRepository.findById(cidadao.getIdUltimoAgendamento());
		if (!optionalAgenda.isPresent()) {
			throw new RegistroInvalido("Agendamento para o CPF " + cidadao.getId() + " nao encontrado.");
		}
		Agenda agenda = optionalAgenda.get();

		if (registroVacinacaoDTO.getDataAplicacao().compareTo(agenda.getHorario()) > 0) {
			throw new RegistroInvalido("Fora do agendamento. Aguarde a sua vez!");
		}

		Optional<Lote> optionalLote = loteRepository.findById(registroVacinacaoDTO.getIdLote());
		if (!optionalLote.isPresent()) {
			throw new RegistroInvalido("Lote nao encontrado.");
		}
		Lote lote = optionalLote.get();

		//TODO alterar os estados do cidadao, provavelmente depois disso a gente conclui as US 18/19
		RegistroVacinacao novoRegistro = new RegistroVacinacao(registroVacinacaoDTO.getIdCidadao(),
				registroVacinacaoDTO.getIdLote(),registroVacinacaoDTO.getDataAplicacao());
		registroVacinacaoRepository.save(novoRegistro);
		return novoRegistro;
        
    }

}
