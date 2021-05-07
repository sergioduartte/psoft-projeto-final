package com.example.projeto_final_psoft.servicos;
import com.example.projeto_final_psoft.DTOs.LoteDTO;
import org.springframework.http.ResponseEntity;
import com.example.projeto_final_psoft.entidades.Lote;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface LoteService {

    Lote cadastrarLote(LoteDTO loteDTO) throws Exception;
    List<Lote> allLotes();
    Lote getLoteById(Long id) throws Exception;
}
