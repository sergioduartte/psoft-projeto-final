package com.ufcg.psoft.projeto_final.services;

import com.ufcg.psoft.projeto_final.DTOs.AgendaDTO;
import com.ufcg.psoft.projeto_final.DTOs.CidadaoDTO;
import com.ufcg.psoft.projeto_final.entidades.Agenda;
import com.ufcg.psoft.projeto_final.entidades.Cidadao;
import com.ufcg.psoft.projeto_final.entidades.Vacina;
import com.ufcg.psoft.projeto_final.erro.AgendamentoCadastroInvalido;
import com.ufcg.psoft.projeto_final.erro.VacinaCadastroInvalido;
import com.ufcg.psoft.projeto_final.exceptions.CadastroAgendamentoException;
import com.ufcg.psoft.projeto_final.exceptions.CadastroVacinaException;
import com.ufcg.psoft.projeto_final.repository.AgendaRepository;
import com.ufcg.psoft.projeto_final.repository.CidadaoRepository;
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

    @Override
    public List<Agenda> getHorarios() {

        List<Agenda> agenda = agendaRepository.findAll();
        List<Agenda> disponiveis = new ArrayList<>();
        for (Agenda alocacao: agenda) {
            if (!alocacao.possuiAlocacao()) {
                disponiveis.add(alocacao);
            }
        }
        return disponiveis;

    }

    @Override
    public Agenda alocaHorario(AgendaDTO agendaDTO) throws AgendamentoCadastroInvalido{

        Optional<Cidadao> optionalCidadao = cidadaoRepository.findById(agendaDTO.getIdCidadao());
        if (!optionalCidadao.isPresent()) {
            throw new AgendamentoCadastroInvalido("Usuario nao encontrado");
        }

        Cidadao cidadao = optionalCidadao.get();
        Agenda novoAgendamento;

        List<Agenda> agenda = agendaRepository.findAll();
        Agenda disponivel;
        for (Agenda alocacao: agenda) {
            if (alocacao.getHorario().equals(agendaDTO.getHorario())) {
                throw new AgendamentoCadastroInvalido("Horario indisponivel");
            }
        }

        // TODO verificar se a dosagem que eu quero agendar a vacinacao eh a mesma que o cidadao pode tomar.

        try {
            novoAgendamento = new Agenda(agendaDTO.getIdCidadao(), agendaDTO.getHorario(), agendaDTO.getDosagem());
        } catch (CadastroAgendamentoException e){
            throw new AgendamentoCadastroInvalido(e.getMessage()); //TODO validacao d
        }
        agendaRepository.save(novoAgendamento);
        return novoAgendamento;
    }
}
