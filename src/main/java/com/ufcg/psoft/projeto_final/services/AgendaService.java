package com.ufcg.psoft.projeto_final.services;

import com.ufcg.psoft.projeto_final.entidades.Agenda;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AgendaService {

    public List<Agenda> getHorarios();

}
