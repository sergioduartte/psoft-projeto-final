package com.ufcg.psoft.projeto_final.services;
import com.ufcg.psoft.projeto_final.DTOs.LoteDTO;
import com.ufcg.psoft.projeto_final.entidades.Lote;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface LoteService {

    Lote saveLote(LoteDTO loteDTO) throws Exception;
    List<Lote> getLote();
    Lote getLoteById(Long id) throws Exception;
}
