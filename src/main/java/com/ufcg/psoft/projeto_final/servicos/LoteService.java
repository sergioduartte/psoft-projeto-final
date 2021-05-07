package com.ufcg.psoft.projeto_final.servicos;
import com.ufcg.psoft.projeto_final.DTOs.LoteDTO;
import com.ufcg.psoft.projeto_final.entidades.Lote;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface LoteService {

    Lote cadastrarLote(LoteDTO loteDTO) throws Exception;
    List<Lote> allLotes();
    Lote getLoteById(Long id) throws Exception;
}
