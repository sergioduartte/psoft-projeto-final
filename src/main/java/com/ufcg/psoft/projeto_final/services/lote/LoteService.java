package com.ufcg.psoft.projeto_final.services.lote;
import com.ufcg.psoft.projeto_final.DTOs.LoteDTO;
import com.ufcg.psoft.projeto_final.models.Lote;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface LoteService {

    Lote saveLote(LoteDTO loteDTO) throws Exception;
    List<Lote> getLote();
    Lote getLoteById(Long id) throws Exception;
}
