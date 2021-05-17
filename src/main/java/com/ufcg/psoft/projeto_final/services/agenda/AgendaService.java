package com.ufcg.psoft.projeto_final.services.agenda;

import com.ufcg.psoft.projeto_final.DTOs.AgendaDTO;
import com.ufcg.psoft.projeto_final.models.Agenda;
import com.ufcg.psoft.projeto_final.errors.AgendamentoCadastroInvalido;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AgendaService {

    List<Agenda> getHorarios();
    Agenda alocaHorario(AgendaDTO agendaDTO) throws AgendamentoCadastroInvalido;

}
