package com.ufcg.psoft.projeto_final.services;

import com.ufcg.psoft.projeto_final.DTOs.AgendaDTO;
import com.ufcg.psoft.projeto_final.DTOs.CidadaoDTO;
import com.ufcg.psoft.projeto_final.entidades.Agenda;
import com.ufcg.psoft.projeto_final.erro.AgendamentoCadastroInvalido;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AgendaService {

    public List<Agenda> getHorarios();

    public Agenda alocaHorario(AgendaDTO agendaDTO) throws AgendamentoCadastroInvalido;
}
