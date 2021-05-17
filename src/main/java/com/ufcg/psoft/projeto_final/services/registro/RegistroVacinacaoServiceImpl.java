package com.ufcg.psoft.projeto_final.services.registro;

import com.ufcg.psoft.projeto_final.DTOs.RegistroVacinacaoDTO;
import com.ufcg.psoft.projeto_final.errors.RegistroInvalido;
import com.ufcg.psoft.projeto_final.models.Agenda;
import com.ufcg.psoft.projeto_final.models.Cidadao;
import com.ufcg.psoft.projeto_final.models.Lote;
import com.ufcg.psoft.projeto_final.models.RegistroVacinacao;
import com.ufcg.psoft.projeto_final.models.situacoes.EnumSituacoes;
import com.ufcg.psoft.projeto_final.models.situacoes.Situacao;
import com.ufcg.psoft.projeto_final.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RegistroVacinacaoServiceImpl implements RegistroVacinacaoService {

    @Autowired
    RegistroVacinacaoRepository registroVacinacaoRepository;
    @Autowired
    CidadaoRepository cidadaoRepository;
    @Autowired
    LoteRepository loteRepository;
    @Autowired
    AgendaRepository agendaRepository;
    @Autowired
    VacinaRepository vacinaRepository;

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
        lote.usaDose();

        EnumSituacoes enumSituacao = cidadao.getSituacao();
        Situacao situacao = enumSituacao.getSituacao();
        Integer dosesNecessarias = vacinaRepository.getOne(cidadao.getIdVacina()).getDosesNecessarias();

        situacao.atualizaSituacao(cidadao, dosesNecessarias);

        RegistroVacinacao novoRegistro = new RegistroVacinacao(registroVacinacaoDTO.getIdCidadao(),
                registroVacinacaoDTO.getIdLote(), registroVacinacaoDTO.getDataAplicacao());
        registroVacinacaoRepository.save(novoRegistro);
        return novoRegistro;

    }

}
