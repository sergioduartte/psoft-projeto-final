package com.ufcg.psoft.projeto_final.services;

import com.ufcg.psoft.projeto_final.DTOs.AgendaDTO;
import com.ufcg.psoft.projeto_final.entidades.Agenda;
import com.ufcg.psoft.projeto_final.entidades.Cidadao;
import com.ufcg.psoft.projeto_final.entidades.Lote;
import com.ufcg.psoft.projeto_final.entidades.situacoes.EnumSituacoes;
import com.ufcg.psoft.projeto_final.erro.AgendamentoCadastroInvalido;
import com.ufcg.psoft.projeto_final.exceptions.CadastroAgendamentoException;
import com.ufcg.psoft.projeto_final.repository.AgendaRepository;
import com.ufcg.psoft.projeto_final.repository.CidadaoRepository;
import com.ufcg.psoft.projeto_final.repository.LoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AgendaServiceImpl implements AgendaService {

	@Autowired
	AgendaRepository agendaRepository;

	@Autowired
	CidadaoRepository cidadaoRepository;

	@Autowired
	LoteRepository loteRepository;

	@Override
	public List<Agenda> getHorarios() {

		List<Agenda> agenda = agendaRepository.findAll();
		List<Agenda> disponiveis = new ArrayList<>();
		for (Agenda alocacao : agenda) {
			if (!alocacao.possuiAlocacao()) {
				disponiveis.add(alocacao);
			}
		}
		return disponiveis;

	}

	@Override
	public Agenda alocaHorario(AgendaDTO agendaDTO) throws AgendamentoCadastroInvalido {

		Optional<Cidadao> optionalCidadao = cidadaoRepository.findById(agendaDTO.getIdCidadao());
		if (!optionalCidadao.isPresent()) {
			throw new AgendamentoCadastroInvalido("Usuario nao encontrado");
		}
		// TODO CRIEI RESERVAS DE VACINAS, POIS NAO SEI LIDAR COM O SCHEDULING - Sergio
		List<Lote> lotes = loteRepository.findAll();
		Lote loteVacina;
		Cidadao cidadao = optionalCidadao.get();

		if (cidadao.getIdVacina() == null) {
			loteVacina = encontraLoteDisponivel(lotes);

		} else {
			loteVacina = checaLotesComVacina(lotes, cidadao);
		}

		Agenda novoAgendamento;

		List<Agenda> agenda = agendaRepository.findAll();
		Agenda disponivel;
		for (Agenda alocacao : agenda) {
			if (alocacao.getHorario().equals(agendaDTO.getHorario())) {
				throw new AgendamentoCadastroInvalido("Horario indisponivel");
			}
		}

		EnumSituacoes situacao = cidadao.getSituacao();
		if (!situacao.equals(EnumSituacoes.APTO_PRIMEIRA_DOSE) || !situacao.equals(EnumSituacoes.APTO_SEGUNDA_DOSE)) {
			throw new AgendamentoCadastroInvalido("Cidadão não está apto para ser vacinado");
		}
		

		try {
			novoAgendamento = new Agenda(agendaDTO.getIdCidadao(), agendaDTO.getHorario(), agendaDTO.getDosagem());
		} catch (CadastroAgendamentoException e) {
			throw new AgendamentoCadastroInvalido(e.getMessage()); // TODO validacao d
		}
		loteVacina.reservaVacina();
		cidadao.setUltimoAgendamento(novoAgendamento.getId());
		agendaRepository.save(novoAgendamento); // TODO essa linha me fez pensar que vamos ter de 'dar save' em tudo o
												// que formos fazer #preocupado
		return novoAgendamento;
	}

	private Lote encontraLoteDisponivel(List<Lote> lotes) throws AgendamentoCadastroInvalido {
		for (Lote lote : lotes) {
			if (lote.getQtdDosesDisponiveis() >= 1) {
				return lote;
			}
		}
		throw new AgendamentoCadastroInvalido("Nao ha vacinas disponiveis.");
	}

	private Lote checaLotesComVacina(List<Lote> lotes, Cidadao cidadao) throws AgendamentoCadastroInvalido {
		for (Lote lote : lotes) {
			if (lote.getIdTipoVacina().equals(cidadao.getIdVacina()) && lote.getQtdDosesDisponiveis() >= 1) {
				return lote;
			}
		}
		throw new AgendamentoCadastroInvalido(
				"Nao ha lote com vacinas com id " + cidadao.getIdVacina() + " disponiveis no momento.");
	}
}
