package com.ufcg.psoft.projeto_final.services.lote;

import com.ufcg.psoft.projeto_final.DTOs.LoteDTO;
import com.ufcg.psoft.projeto_final.models.Lote;
import com.ufcg.psoft.projeto_final.models.Vacina;
import com.ufcg.psoft.projeto_final.errors.LoteCadastroInvalido;
import com.ufcg.psoft.projeto_final.errors.LoteNaoEncontrado;
import com.ufcg.psoft.projeto_final.exceptions.CadastroLoteException;
import com.ufcg.psoft.projeto_final.repositories.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
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
    public Lote saveLote(LoteDTO loteDTO) throws LoteCadastroInvalido {

        Date data_validade; //refatorar data
        try {
            data_validade = new SimpleDateFormat("yyyy-MM-dd").parse(loteDTO.getDataValidade());
        } catch (ParseException e) {
            throw new LoteCadastroInvalido("Data passada nao esta no formato \"yyyy - MM - dd\".");
        }
        Optional<Vacina> vacina = vacinaRepository.findById(loteDTO.getIdTipoVacina());
        if (!vacina.isPresent()) {
            throw new LoteCadastroInvalido("Tipo de Vacina não econtrado.");
        }
        Lote novoLote;
        try {
            novoLote = new Lote(data_validade, loteDTO.getQtdDoses(), loteDTO.getFabricanteVacina(), loteDTO.getIdTipoVacina());
        } catch (CadastroLoteException e) {
            throw new LoteCadastroInvalido(e.getMessage());
        }

        loteRepository.save(novoLote);
        return novoLote;
    }

    @Override
    public List<Lote> getLote() {
        return loteRepository.findAll();
    }

    @Override
    public Lote getLoteById(Long id) throws LoteNaoEncontrado {
        Optional<Lote> loteEncontrado = loteRepository.findById(id);
        if (!loteEncontrado.isPresent()) throw new LoteNaoEncontrado(id);
        return loteEncontrado.get();
    }

}
