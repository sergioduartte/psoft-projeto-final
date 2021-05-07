package com.example.projeto_final_psoft.servicos;

import com.example.projeto_final_psoft.DTOs.LoteDTO;
import com.example.projeto_final_psoft.daos.VacinaRepository;
import com.example.projeto_final_psoft.entidades.Cidadao;
import com.example.projeto_final_psoft.entidades.Lote;
import com.example.projeto_final_psoft.entidades.Vacina;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import com.example.projeto_final_psoft.repositorios.LoteRepository;
import org.springframework.stereotype.Service;

import javax.websocket.server.ServerEndpoint;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class LoteServiceImpl implements  LoteService{

    @Autowired
    LoteRepository loteRepository;

    @Autowired
    VacinaRepository vacinaRepository;


    @Override
    public Lote cadastrarLote(LoteDTO loteDTO) throws Exception {
        Date data_validade = new SimpleDateFormat("yyyy-MM-dd").parse(loteDTO.getDataValidade());
        Optional<Vacina> vacina = vacinaRepository.findById(loteDTO.getIdVacina());
        if (!vacina.isPresent()) {
            throw new Exception("infelizmente, essa vacina é inexistente");
        }

        Lote novoLote = new Lote(data_validade, loteDTO.getQtdDoses(), vacina.get());
        loteRepository.save(novoLote);
        return novoLote;
    }

    @Override
    public List<Lote> allLotes() {
        return loteRepository.findAll();
    }

    @Override
    public Lote getLoteById(Long id) throws Exception {
        Optional<Lote> loteEncontrado = loteRepository.findById(id);
        if (!loteEncontrado.isPresent()) throw new Exception("infelizmente, essa vacina é inexistente");
        return loteEncontrado.get();
    }

}
