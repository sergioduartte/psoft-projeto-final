package com.ufcg.psoft.projeto_final.services;

import com.ufcg.psoft.projeto_final.entidades.Agenda;
import com.ufcg.psoft.projeto_final.repository.AgendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AgendaServiceImpl implements AgendaService {

    @Autowired
    AgendaRepository agendaRepository;

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
}
