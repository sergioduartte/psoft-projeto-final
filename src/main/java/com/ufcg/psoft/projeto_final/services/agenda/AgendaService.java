package com.ufcg.psoft.projeto_final.services.agenda;

import com.ufcg.psoft.projeto_final.DTOs.AgendaDTO;
import com.ufcg.psoft.projeto_final.errors.AgendamentoCadastroInvalido;
import com.ufcg.psoft.projeto_final.exceptions.NaoAutorizadoException;
import com.ufcg.psoft.projeto_final.models.Agenda;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AgendaService {

    List<Agenda> getHorarios();

    Agenda alocaHorario(AgendaDTO agendaDTO, HttpHeaders headers) throws AgendamentoCadastroInvalido, NaoAutorizadoException;

}
